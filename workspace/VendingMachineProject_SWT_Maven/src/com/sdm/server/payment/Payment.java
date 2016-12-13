/**
 * 
 */
package com.sdm.server.payment;

import java.math.BigDecimal;

import com.sdm.server.sale.Receipt;
import com.sdm.server.sale.Sale;

/**
 * This is an interface which initiates the payment and prints the receipt to the user.
 * 
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 19, 2016 7:57:30 PM
 * @Project Assignment 5
 */
public abstract class Payment {
	private Receipt receipt;
	private String paymentType;
	
	/**
	 * This method is responsible for user payment by identifying the product with its amount tendered.
	 * @param product
	 * @param amountTendered
	 */
	public abstract void makePayment(Sale sale, BigDecimal amountTendered);
	
	/**
	 * This method prints the receipt to the user by calculating the balance amount.
	 * @param product
	 * @param amountTendered
	 * @return
	 */
	protected void printReceipt(BigDecimal amountTendered, BigDecimal balanceAmount) {
		receipt = new Receipt(amountTendered, balanceAmount);
	}
	
	public Receipt getReceipt() {
		return receipt;
	}
	
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	
	public String getPaymentType() {
		return paymentType;
	}
}
