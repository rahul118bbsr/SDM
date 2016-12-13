/**
 * 
 */
package com.sdm.server.controller;

import java.math.BigDecimal;
import java.util.List;

import com.sdm.common.exception.InvalidPaymentException;
import com.sdm.common.exception.PurchaseLimitExceeded;
import com.sdm.server.product.Product;
import com.sdm.server.sale.Sale;

/**
 * This handles the actions of the vending machines that is being used by the user trying to purchase items.
 * 
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 20, 2016 10:19:33 PM
 * @Project Assignment 5
 */
public interface IVendingMachine {
	
	List<Product> fetchProductCatalog();
	
	Sale makeNewSale();
	
	/**
	 * This method is responsible to initiate the  new sale by passing the product id.
	 * 
	 * @param productId - the id of product that is being purchased
	 */
	void enterItemID(String productId);
	
	/**
	 * This method is responsible to initiate the end sale by passing the payment type and amount tendered.
	 * 
	 * @param paymentType - way the user wants to make the purchase
	 * @param amountTendered - final amount that needs to be paid for the product purchase
	 */
	void endSale(String paymentType, BigDecimal amountTendered) throws InvalidPaymentException, PurchaseLimitExceeded;
}
