/**
 * 
 */
package com.sdm.controller;

import java.math.BigDecimal;

import com.sdm.sale.Sale;

/**
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 20, 2016 10:20:35 PM
 * @Project Assignment 5
 */
public class VendingMachine implements IVendingMachine {
	private Sale sale;

	/* (non-Javadoc)
	 * @see com.sdm.controller.IVendingMachine#makeNewSale()
	 */
	@Override
	public void makeNewSale(String productId) {
		sale = new Sale(productId);
		sale.makeNewSale();

	}

	/* (non-Javadoc)
	 * @see com.sdm.controller.IVendingMachine#endSale()
	 */
	@Override
	public void endSale(String paymentType, BigDecimal amountTendered) {
		sale.endSale(paymentType, amountTendered);

	}

}
