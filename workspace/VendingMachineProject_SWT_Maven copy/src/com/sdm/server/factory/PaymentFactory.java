/**
 * 
 */
package com.sdm.server.factory;

import com.sdm.common.enums.PaymentEnum;
import com.sdm.server.payment.Payment;

/**
 * The factory class which provides the payment type during the transaction.s
 * 
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 20, 2016 12:37:36 PM
 * @Project Assignment 5
 */
public class PaymentFactory {
	private PaymentFactory(){
	}
	
	public static Payment fetchPaymentType(String paymentType){
		return PaymentEnum.valueOf(paymentType).getPaymentType();
	}
}
