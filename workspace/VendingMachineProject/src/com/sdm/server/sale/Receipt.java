/**
 * 
 */
package com.sdm.sale;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.sdm.product.Product;

/**
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 20, 2016 10:01:34 AM
 * @Project Assignment 5
 */
public class Receipt {
	private Product product;
	private BigDecimal tenderedAmount = BigDecimal.ZERO;
	private BigDecimal balanceAmount = BigDecimal.ZERO;
	
	@Override
	public String toString() {
		String str = "\n********************************************************* \n";
		str = str + "Receipt Details: \n";
		str = str + "\t\t\tOnly the Best Ven \n" + "\t\t\tMelbourne, Florida - 32901\n";
		str = str + "\t\t\tDate: " + LocalDateTime.now() + "\n\n";
		str = str + product.getProductDescription().getDescription() + "\t\t\t$" 
		+ product.getProductDescription().getPrice() + "\n";
		str = str + "TOTAL\t\t\t\t$" + product.getProductDescription().getPrice() + "\n";
		str = str + "AMOUNT TENDERED\t\t\t$" + tenderedAmount + "\n";
		str = str + "CHANGE DUE\t\t\t$" + balanceAmount + "\n";
		str = str + "*********************************************************";
		return str;
	}
	
	public Receipt(Product product, BigDecimal tenderedAmount, BigDecimal balanceAmount) {
		this.product = product;
		this.tenderedAmount = tenderedAmount;
		this.balanceAmount = balanceAmount;
	}
	
	public Receipt printReceipt() {
		System.out.println(this);
		return this;
	}

}
