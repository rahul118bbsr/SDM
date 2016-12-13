/**
 * 
 */
package com.sdm.server.email;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDateTime;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.canvas.draw.DottedLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.sdm.common.util.CurrencyHelper;
import com.sdm.server.sale.Sale;
import com.sdm.server.tax.taxrules.model.TaxTypeModel;
import com.sdm.server.util.UserHelper;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 05-Dec-2016 3:55:16 PM
 *
 */
public class ReceiptPDFGenerator {
	private String pdfLocation = null;
	private String pdfFileName = null;
	private Sale sale;
	
	public ReceiptPDFGenerator(Sale sale) {
		this.sale = sale;
	}

	public void generateReceipt() {
		try {
			PdfWriter pdfWriter = new PdfWriter(fetchTempFileLocation());
			PdfDocument pdfDocument = new PdfDocument(pdfWriter);
			Document doc = new Document(pdfDocument);
			addImage(doc);
			addPageBackgroundColor(pdfDocument, doc);
			addImage(doc);
			addSeparator(doc);
			addBody(doc);
			addReceiptDetails(doc);
			addBodyEnd(doc);
			doc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addBodyEnd(Document doc) {
		String text = "Thank you for shopping with OnlyTheBestVen. Only the best at your service.";
		addTextToParagraph(doc, text);
	}
	
	private void addTextToParagraph(Document doc, String str) {
		Text text = new Text(str);
		text.setFontColor(Color.BLACK);
		text.setFontSize(14);
		Paragraph paragraph = new Paragraph(text);
		doc.add(paragraph);
	}

	private void addSeparator(Document doc) {
		addEmptyPargraph(doc);
		DottedLine customLine= new DottedLine();
		customLine.setGap(5);
		customLine.setLineWidth(3);
		doc.add(new LineSeparator(customLine));	
	}

	private void addBody(Document doc) {
		Text text1 = new Text("Receipt for your " + sale.getPayment().getPaymentType() + " purchase");
		text1.setBold();
		text1.setFontColor(new DeviceRgb(0, 77, 153)); //230, 138, 0
		text1.setFontSize(25);
		Paragraph paragraph1 = new Paragraph(text1);
		doc.add(paragraph1);
		addEmptyPargraph(doc);
		
		String body = "Hello " + UserHelper.getInstance().getUserName() + ",\n";
		body = body + "Thank you for using OnlyTheBestVen. Here is a receipt for your records.";
		Text text2 = new Text(body);
		text2.setFontColor(Color.BLACK);
		text2.setFontSize(14);
		addEmptyPargraph(doc);
		Paragraph paragraph2 = new Paragraph(text2);
		doc.add(paragraph2);
		addEmptyPargraph(doc);
		
		body = "Purchase Details:";
		Text text3 = new Text(body);
		text3.setFontColor(Color.BLACK);
		text3.setBold();
		text3.setFontSize(16);
		Paragraph paragraph3 = new Paragraph(text3);
		doc.add(paragraph3);		
	}
	
	private void addReceiptDetails(Document doc) {
		Table table = new Table(2, true);
		table.addCell(new Cell().add(sale.getProduct().getProductDescription().getDescription()).setBorder(Border.NO_BORDER))
		.setFontColor(Color.BLACK);
		String currency = " " + CurrencyHelper.fetchCurrency();
		table.addCell(new Cell().add(sale.getProduct().getProductDescription().getPrice().toString() + currency).setBorder(Border.NO_BORDER))
		.setFontColor(Color.BLACK);
		
        for (TaxTypeModel taxType : sale.getTaxModel().getTaxTypeModelList()) {
        	table.addCell(new Cell().add(taxType.getTaxName()).setBorder(Border.NO_BORDER)).setFontColor(Color.BLACK);
        	table.addCell(new Cell().add(taxType.getTaxValue().toString() + "%").setBorder(Border.NO_BORDER)).setFontColor(Color.BLACK);
        }
        table.addCell(new Cell().add("TOTAL").setBorder(Border.NO_BORDER)).setFontColor(Color.BLACK);
        table.addCell(new Cell().add(sale.getTaxModel().getProductPriceIncludingTax() + currency).setBorder(Border.NO_BORDER)).setFontColor(Color.BLACK);
        
        table.addCell(new Cell().add("AMOUNT TENDERED").setBorder(Border.NO_BORDER)).setFontColor(Color.BLACK);
        table.addCell(new Cell().add(sale.getPayment().getReceipt().getTenderedAmount() + currency).setBorder(Border.NO_BORDER)).setFontColor(Color.BLACK);
        
        table.addCell(new Cell().add("CHANGE DUE").setBorder(Border.NO_BORDER)).setFontColor(Color.BLACK);
        table.addCell(new Cell().add(sale.getPayment().getReceipt().getBalanceAmount() + currency).setBorder(Border.NO_BORDER)).setFontColor(Color.BLACK);
        
        doc.add(table);
        table.complete();
        addEmptyPargraph(doc);
	}

	private void addEmptyPargraph(Document doc) {
		doc.add(new Paragraph(new Text("")));
	}

	private void addPageBackgroundColor(PdfDocument pdfDocument, Document doc) {
		PdfCanvas canvas = new PdfCanvas(doc.getPdfDocument(), 1);
		canvas.rectangle(0, 0, pdfDocument.getDefaultPageSize().getWidth(), pdfDocument.getDefaultPageSize().getHeight());
		canvas.setColor(new DeviceRgb(235, 235, 224), true);
		canvas.fill();
	}

	private Image addImage(Document doc) throws MalformedURLException {
		Image image = new Image(ImageDataFactory.create("/Users/aleesha/Desktop/logo.png"));
		doc.add(image);
		return image;
	}

	private String fetchTempFileLocation() throws IOException {
		// create a temp file
		LocalDateTime localDateTime = LocalDateTime.now();
		pdfFileName = "OnlyTheBestVen-Rceipt-" + localDateTime + ".pdf";
		pdfLocation = File.createTempFile(pdfFileName, "").getAbsolutePath();
		return pdfLocation;
	}

	public String getPdfLocation() {
		return pdfLocation;
	}

	public String getPdfFileName() {
		return pdfFileName;
	}

}
