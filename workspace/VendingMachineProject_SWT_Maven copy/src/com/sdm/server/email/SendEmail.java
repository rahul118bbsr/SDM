/**
 * 
 */
package com.sdm.server.email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sdm.server.sale.Sale;

/**
 * This class is responsible for sending the purchase receipt via email to the user's mail id. This is spawned of a different thread so that
 * the user can continue to use the GUI, while at the same time this thread prepares the receipt and emails it. Otherwise, had this whole thing
 * be a single threaded application, the GUI would have been in a suspended / hung state till the email application is done sending the mail.
 * 
 * @author Rahul Dev Mishra
 * @assignment
 * @date 05-Dec-2016 3:53:04 PM
 *
 */

public class SendEmail implements Runnable{
	private Sale sale;
	private ReceiptPDFGenerator receiptPDFGenerator;

	public SendEmail(Sale sale) {
		this.sale = sale;
	}
	

	@Override
	public void run() {
		sendEmail();
	}

	public void sendEmail() {
		generateReceipt();

		Properties propsSSL = new Properties();
		// EVEN IF YOU SKIP THESE TWO PROP IT WOULD WORK
		propsSSL.put("mail.transport.protocol", EmailConstants.TRANSPORT_PROTOCOL);
		propsSSL.put("mail.smtps.host", EmailConstants.SMTPS_HOST);

		// THIS IS THE MOST IMPORTANT PROP --> "mail.smtps.auth"
		propsSSL.put("mail.smtps.auth", EmailConstants.SMTPS_AUTH);

		Session sessionSSL = Session.getInstance(propsSSL);
		sessionSSL.setDebug(true);

		Message message = new MimeMessage(sessionSSL);
		try {
			message.setFrom(new InternetAddress(EmailConstants.FROM, EmailConstants.PERSONAL));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(EmailConstants.TO)); // real recipient
			String subject = "Your OnlyTheBestVen order of \"" + sale.getProduct().getProductDescription().getDescription() + "\"";
			message.setSubject(subject);
			BodyPart messageBodyPart = new MimeBodyPart();
	        messageBodyPart.setText("");
	        Multipart multipart = new MimeMultipart();
	        multipart.addBodyPart(messageBodyPart);
	        messageBodyPart = new MimeBodyPart();
	        DataSource source = new FileDataSource(receiptPDFGenerator.getPdfLocation());
	        messageBodyPart.setDataHandler(new DataHandler(source));
	        messageBodyPart.setFileName(receiptPDFGenerator.getPdfFileName());
	        multipart.addBodyPart(messageBodyPart);
	        message.setContent(multipart);

			Transport transportSSL = sessionSSL.getTransport();
			// EVEN IF YOU SKIP PORT NUMBER , IT WOULD WORK
			transportSSL.connect(EmailConstants.SMTPS_HOST, EmailConstants.TRANSPORT_PORT, EmailConstants.FROM, EmailConstants.PASSWD); // account used
			transportSSL.sendMessage(message, message.getAllRecipients());
			transportSSL.close();
		} catch (UnsupportedEncodingException | MessagingException e) {
			e.printStackTrace();
		}

		System.out.println("Mail Sent Successfully.");
	}

	private void generateReceipt() {
		receiptPDFGenerator = new ReceiptPDFGenerator(sale);
		receiptPDFGenerator.generateReceipt();
	}

}
