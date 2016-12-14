/**
 * 
 */
package com.sdm.server.sale;

import java.math.BigDecimal;

import com.sdm.server.product.Product;

/**
 * This is a class which hold the product user has selected with its description and price.
 * 
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 19, 2016 7:28:52 PM
 * @Project Assignment 5
 */
public class SaleLineItem {
	
	/**
	 * This method gets the subtotal price of the product, the user has selected.
	 * @param product
	 * @return
	 */
	public BigDecimal getSubTotal(Product product){
		return product.getProductDescription().getPrice();
	}
}
