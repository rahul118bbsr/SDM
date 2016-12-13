/**
 * 
 */
package com.sdm.sale;

import java.math.BigDecimal;

import com.sdm.enums.ProductCatalogEnum;
import com.sdm.factory.PaymentFactory;
import com.sdm.payment.IPayment;
import com.sdm.product.Product;
import com.sdm.product.ProductCatalog;

/**
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 20, 2016 10:01:15 AM
 * @Project Assignment 5
 */
public class Sale {
	private String productId;
	private Product product;
	private IPayment payment;
	private SaleLineItem saleLineItem;
	private CentralSite centralSite;

	public Sale(String productId) {
		this.productId = productId;
		this.centralSite = new CentralSite();
	}

	public void makeNewSale() {
		ProductCatalogEnum productCatalogEnum = ProductCatalogEnum.valueOf(productId);
		product = ProductCatalog.getProductCatalogMap().get(productCatalogEnum);
		saleLineItem = new SaleLineItem();
		BigDecimal subTotal = saleLineItem.getSubTotal(product);
		System.out.println("Following item selected for purchase");
		System.out.println(product.getProductDescription().getDescription() + "\t\t$" + subTotal);
	}
	
	public void endSale(String paymentType, BigDecimal amountTendered) {
		payment = PaymentFactory.fetchPaymentType(paymentType);
		payment.makePayment(product, amountTendered);
		centralSite.updateSaleTransaction(this);
	}

}
