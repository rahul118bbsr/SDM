/**
 * 
 */
package com.sdm.factory;

import com.sdm.enums.PaymentEnum;
import com.sdm.payment.IPayment;

/**
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 20, 2016 12:37:36 PM
 * @Project Assignment 5
 */
public class PaymentFactory {
	private PaymentFactory(){
	}
	
	public static IPayment fetchPaymentType(String paymentType){
		return PaymentEnum.valueOf(paymentType).getPaymentType();
	}
}
