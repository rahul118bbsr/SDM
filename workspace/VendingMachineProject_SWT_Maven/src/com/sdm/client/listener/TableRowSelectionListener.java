/**
 * 
 */
package com.sdm.client.listener;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import com.sdm.client.ClientSaleDisplay;
import com.sdm.server.controller.IVendingMachine;

/**
 * This listener class listens to any selection change that happens on the product catalog table. And accordingly it calculates the tax price. 
 * 
 * @author Rahul Dev Mishra, Aleesha Mishra
 * @assignment Assignment 7  
 * @date 21-Nov-2016 12:23:29 PM
 *
 */
public class TableRowSelectionListener implements SelectionListener {
	private IVendingMachine vendingMachine;
	private ClientSaleDisplay clientSaleDisplay;
	
	public TableRowSelectionListener(ClientSaleDisplay clientSaleDisplay, IVendingMachine vendingMachine) {
		this.vendingMachine = vendingMachine;
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
	public void widgetSelected(SelectionEvent event) {
		Table table = (Table) event.getSource();
		TableItem tableItem = table.getSelection()[0];
		vendingMachine.enterItemID(tableItem.getText());
		for(Button button : clientSaleDisplay.getPaymentModeRadioBtns()) {
			button.setEnabled(true);
		}
	}

}
