/**
 * 
 */
package main.com.sdm.server.sale;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import main.com.sdm.client.listener.PropertyListener;
import main.com.sdm.common.exception.InvalidPaymentException;
import main.com.sdm.common.exception.PurchaseLimitExceeded;
import main.com.sdm.server.factory.PaymentFactory;
import main.com.sdm.server.model.TaxModel;
import main.com.sdm.server.payment.Payment;
import main.com.sdm.server.product.Product;
import main.com.sdm.server.product.ProductCatalog;
import main.com.sdm.server.service.IProductCatalogService;
import main.com.sdm.server.service.ITransactionsService;
import main.com.sdm.server.service.ProductCatalogService;
import main.com.sdm.server.service.TransactionsService;
import main.com.sdm.server.util.TaxCalculationHelper;

/**
 * This is a class in which the actual new sale is done and end sale is
 * initiated and updates the central site of the current purchase
 * 
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 20, 2016 10:01:15 AM
 * @Project Assignment 5
 */
public class Sale {
	private Product product;
	private Payment payment;
	private SaleLineItem saleLineItem;
	private TaxModel taxModel;
	private List<PropertyListener> propertyListenerList = new ArrayList<>();

	public Sale() {
		this.taxModel = new TaxModel();
	}

	/**
	 * This method is responsible to initiate the new sale by passing the
	 * product id.
	 * 
	 * @param productId
	 */
	public void enterItem(String productId) {
		product = ProductCatalog.getProductCatalogMap().get(productId);
		BigDecimal subTotal = fetchSaleLineItem();
		taxModel.setTaxTypeModelList(TaxCalculationHelper.fetchAllTaxTypes());
		taxModel.setProductPriceIncludingTax(TaxCalculationHelper.calculatePriceWithTax(subTotal));
		publishPropertyEventBeforeSale();
	}

	/**
	 * This method is responsible to initiate the end sale by passing the
	 * payment type and amount tendered.
	 * 
	 * @param paymentType
	 * @param amountTendered
	 */
	public void endSale(String paymentType, BigDecimal amountTendered) throws InvalidPaymentException, PurchaseLimitExceeded{
		payment = PaymentFactory.fetchPaymentType(paymentType);
		payment.setPaymentType(paymentType);
		payment.makePayment(this, amountTendered);
		publishPropertyEventAfterSale();
		IProductCatalogService productCatalogService = new ProductCatalogService();
		productCatalogService.updateProductQuantCountByMinusOne(product);
		ITransactionsService transactionsService = new TransactionsService();
		transactionsService.save(this);
	}

	private BigDecimal fetchSaleLineItem() {
		saleLineItem = new SaleLineItem();
		return saleLineItem.getSubTotal(product);
	}

	public void addListener(PropertyListener listener) {
		propertyListenerList.add(listener);
	}

	private void publishPropertyEventBeforeSale() {
		propertyListenerList.stream().forEach(x -> x.onPropertyEventBeforeSale(this));
	}

	private void publishPropertyEventAfterSale() {
		propertyListenerList.stream().forEach(x -> x.onPropertyEventAfterSale(this));
	}

	public SaleLineItem getSaleLineItem() {
		return saleLineItem;
	}

	public Payment getPayment() {
		return payment;
	}

	public TaxModel getTaxModel() {
		return taxModel;
	}

	public Product getProduct() {
		return product;
	}
}
