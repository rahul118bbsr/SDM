/**
 * 
 */
package com.sdm.controller;

import java.math.BigDecimal;

/**
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 20, 2016 10:19:33 PM
 * @Project Assignment 5
 */
public interface IVendingMachine {
	void makeNewSale(String productId);
	void endSale(String paymentType, BigDecimal amountTendered);
}
