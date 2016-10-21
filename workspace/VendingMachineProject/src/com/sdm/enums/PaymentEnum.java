/**
 * 
 */
package com.sdm.enums;

import com.sdm.payment.CardPayment;
import com.sdm.payment.CashPayment;
import com.sdm.payment.IPayment;

/**
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 19, 2016 7:56:04 PM
 * @Project Assignment 5
 */
public enum PaymentEnum {
	CARD("CARD", new CardPayment()),
	CASH("CASH", new CashPayment());
	
	private IPayment paymentType;
	private String paymentTypeStr;
	
	private PaymentEnum(String paymentTypeStr, IPayment payment) {
		this.paymentType = payment;
		this.paymentTypeStr = paymentTypeStr;
	}
	
	public IPayment getPaymentType() {
		return paymentType;
	}
	
	public String getPaymentTypeStr() {
		return paymentTypeStr;
	}
	
	public static void displayPaymentModes() {
		System.out.println("Payment modes available:");
		for(PaymentEnum paymentEnum : PaymentEnum.values()) {
			System.out.println(paymentEnum.paymentTypeStr);
		}
	}
	
}
