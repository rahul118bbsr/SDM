/**
 * 
 */
package com.sdm.payment;

import java.math.BigDecimal;

import com.sdm.product.Product;
import com.sdm.sale.Receipt;

/**
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 19, 2016 7:57:30 PM
 * @Project Assignment 5
 */
public interface IPayment {
	void makePayment(Product product, BigDecimal amountTendered);
	Receipt printReceipt(Product product, BigDecimal amountTendered);
}
