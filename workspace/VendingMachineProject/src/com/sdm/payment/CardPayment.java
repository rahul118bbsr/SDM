/**
 * 
 */
package com.sdm.payment;

import java.math.BigDecimal;

import com.sdm.product.Product;
import com.sdm.sale.Receipt;

/**
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 19, 2016 7:58:52 PM
 * @Project Assignment 5
 */
public class CardPayment implements IPayment {

	/* (non-Javadoc)
	 * @see com.sdm.payment.IPayment#makePayment(com.sdm.product.Product)
	 */
	@Override
	public void makePayment(Product product, BigDecimal amountTendered) {
		System.out.println("Card Payment Is Successful");
		printReceipt(product, amountTendered);
	}
	
	@Override
	public Receipt printReceipt(Product product, BigDecimal amountTendered) {
		Receipt receipt = new Receipt(product, BigDecimal.ZERO, BigDecimal.ZERO);
		return receipt.printReceipt();
	}
}
