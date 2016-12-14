/**
 * 
 */
package main.com.sdm.client.listener;

import java.math.BigDecimal;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.MessageBox;

import main.com.sdm.client.ClientSaleDisplay;
import main.com.sdm.common.exception.InvalidPaymentException;
import main.com.sdm.common.exception.ProductNotFoundException;
import main.com.sdm.common.exception.PurchaseLimitExceeded;

/**
 * This class listens to Buy button listener. On click, it performs few validations before calling the server to make the payment.
 * 
 * @author Rahul Dev Mishra, Aleesha Mishra
 * @assignment Assignment 7  
 * @date 21-Nov-2016 5:53:30 PM
 *
 */
public class BuyButtonListener implements SelectionListener {
	private ClientSaleDisplay clientSaleDisplay;

	public BuyButtonListener(ClientSaleDisplay clientSaleDisplay) {
		this.clientSaleDisplay = clientSaleDisplay;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
	 */
	@Override
	public void widgetSelected(SelectionEvent arg0) {
		int style = SWT.ICON_WORKING | SWT.OK;
		MessageBox dia = new MessageBox(clientSaleDisplay.getShell(), style);
        dia.setText("Only the Best Ven");
		try{
			String cashText = clientSaleDisplay.getCashText().getText().trim();
			BigDecimal paymentAmount = "".equals(cashText) ? BigDecimal.ZERO : new BigDecimal(cashText);
			clientSaleDisplay.getVendingMachine().endSale(clientSaleDisplay.getPaymentMode(), paymentAmount);
			dia.setMessage("Transaction is successfull..."); 
	        dia.open();
	        clientSaleDisplay.getShell().dispose();
		} catch(InvalidPaymentException | PurchaseLimitExceeded | ProductNotFoundException e) {
			style = SWT.ICON_ERROR | SWT.OK;
	        dia.setMessage(e.getMessage()); 
	        dia.open();
		}
	}
}
