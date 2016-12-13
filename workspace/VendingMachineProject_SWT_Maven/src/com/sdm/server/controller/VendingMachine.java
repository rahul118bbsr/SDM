/**
 * 
 */
package com.sdm.server.controller;

import java.math.BigDecimal;
import java.util.List;

import com.sdm.common.exception.InvalidPaymentException;
import com.sdm.common.exception.PurchaseLimitExceeded;
import com.sdm.server.email.SendEmail;
import com.sdm.server.product.Product;
import com.sdm.server.product.ProductCatalog;
import com.sdm.server.sale.CentralSite;
import com.sdm.server.sale.Sale;

/**
 * This handles the actions of the vending machines that is being used by the
 * user trying to purchase items.
 * 
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 20, 2016 10:20:35 PM
 * @Project Assignment 5
 */
public class VendingMachine implements IVendingMachine {
	private Sale sale;
	private CentralSite centralSite;

	@Override
	public Sale makeNewSale() {
		sale = new Sale();
		return sale;
	}

	@Override
	public List<Product> fetchProductCatalog() {
		return ProductCatalog.fetchProductCatalog();
	}

	/**
	 * This method is responsible to initiate the new sale by passing the
	 * product id.
	 * 
	 * @param productId
	 *            - the id of product that is being purchased
	 */
	@Override
	public void enterItemID(String productId) {
		sale.enterItem(productId);

	}

	/**
	 * This method is responsible to initiate the end sale by passing the
	 * payment type and amount tendered.
	 * 
	 * @param paymentType
	 *            - way the user wants to make the purchase
	 * @param amountTendered
	 *            - final amount that needs to be paid for the product purchase
	 */
	@Override
	public void endSale(String paymentType, BigDecimal amountTendered)
			throws InvalidPaymentException, PurchaseLimitExceeded {
		sale.endSale(paymentType, amountTendered);
		updateSaleTransactionToCentralSite();
		emailReceipt();
	}

	private void updateSaleTransactionToCentralSite() {
		centralSite = CentralSite.getInstance();
		centralSite.updateSaleTransaction(sale);
	}

	private void emailReceipt() {
		SendEmail saleRunnable = new SendEmail(sale);
		Thread t = new Thread(saleRunnable);
		t.start();
	}

}
