/**
 * 
 */
package com.sdm.sale;

import java.math.BigDecimal;

import com.sdm.product.Product;

/**
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 19, 2016 7:28:52 PM
 * @Project Assignment 5
 */
public class SaleLineItem {
	public BigDecimal getSubTotal(Product product){
		return product.getProductDescription().getPrice();
	}
}
