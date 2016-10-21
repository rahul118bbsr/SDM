/**
 * 
 */
package com.sdm.payment;

import java.math.BigDecimal;

import com.sdm.product.Product;
import com.sdm.sale.Receipt;

/**
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 19, 2016 7:59:18 PM
 * @Project Assignment 5
 */
public class CashPayment implements IPayment {
	
	/* (non-Javadoc)
	 * @see com.sdm.payment.IPayment#makePayment(com.sdm.product.Product)
	 */
	@Override
	public void makePayment(Product product, BigDecimal amountTendered) {
		BigDecimal balance = amountTendered.subtract(product.getProductDescription().getPrice());
		if(balance.compareTo(BigDecimal.ZERO) < 0) {
			System.out.println("Amount entered $" + amountTendered + " is lesser than the price of " + product.getProductDescription().getDescription() 
					+ " $" + product.getProductDescription().getPrice());
			System.out.println("Please try purchasing the product again.");
			return;
		}
		System.out.println("Cash Payment Is Successful");
		printReceipt(product, amountTendered);
	}

	@Override
	public Receipt printReceipt(Product product, BigDecimal amountTendered) {
		BigDecimal balanceAmount = amountTendered.subtract(product.getProductDescription().getPrice());
		Receipt receipt = new Receipt(product, amountTendered, balanceAmount);
		return receipt.printReceipt();
	}
}
