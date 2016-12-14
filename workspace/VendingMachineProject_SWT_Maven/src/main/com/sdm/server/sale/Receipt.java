/**
 * 
 */
package main.com.sdm.server.sale;

import java.math.BigDecimal;

/**
 * This is the class which generated the receipt to the user at the end of the sale process.
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 20, 2016 10:01:34 AM
 * @Project Assignment 5
 */
public class Receipt {
	private BigDecimal tenderedAmount = BigDecimal.ZERO;
	private BigDecimal balanceAmount = BigDecimal.ZERO;
	
	public Receipt(BigDecimal tenderedAmount, BigDecimal balanceAmount) {
		this.tenderedAmount = tenderedAmount;
		this.balanceAmount = balanceAmount;
	}
	
	public BigDecimal getTenderedAmount() {
		return tenderedAmount;
	}
	
	public BigDecimal getBalanceAmount() {
		return balanceAmount;
	}

}
