/**
 * 
 */
package com.sdm.common.enums;

import com.sdm.server.payment.CardPayment;
import com.sdm.server.payment.CashPayment;
import com.sdm.server.payment.Payment;

/**
 * It is an enum consisting of the payment types currently available in the vending machine.
 * 
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 19, 2016 7:56:04 PM
 * @Project Assignment 5
 */
public enum PaymentEnum {
	CARD("CARD", new CardPayment()),
	CASH("CASH", new CashPayment());
	
	private Payment paymentType;
	private String paymentTypeStr;
	
	private PaymentEnum(String paymentTypeStr, Payment payment) {
		this.paymentType = payment;
		this.paymentTypeStr = paymentTypeStr;
	}
	
	public Payment getPaymentType() {
		return paymentType;
	}
	
	public String getPaymentTypeStr() {
		return paymentTypeStr;
	}
	
	
	/**
	 * This method shows the various payment options in the system.
	 */
	public static void displayPaymentModes() {
		System.out.println("Payment modes available:");
		for(PaymentEnum paymentEnum : PaymentEnum.values()) {
			System.out.println(paymentEnum.paymentTypeStr);
		}
	}
	
}
