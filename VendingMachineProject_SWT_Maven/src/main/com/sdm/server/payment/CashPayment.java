/**
 * 
 */
package main.com.sdm.server.payment;

import java.math.BigDecimal;

import main.com.sdm.common.exception.InvalidPaymentException;
import main.com.sdm.common.util.CurrencyHelper;
import main.com.sdm.server.product.Product;
import main.com.sdm.server.sale.Sale;

/**
 * This class is invoked when user selects the cash payment option and payment is made calculating the desired
 * balance amount.
 * 
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 19, 2016 7:59:18 PM
 * @Project Assignment 5
 */
public class CashPayment extends Payment {
	/**
	 * This method is responsible for user payment by identifying the product with its amount tendered.
	 * 
	 * @param product
	 * @param amountTendered
	 */
	@Override
	public void makePayment(Sale sale, BigDecimal amountTendered) {
		String currency = " " + CurrencyHelper.fetchCurrency();
		Product product = sale.getProduct();
		BigDecimal priceWithTax = sale.getTaxModel().getProductPriceIncludingTax();
		BigDecimal balanceAmount = amountTendered.subtract(priceWithTax);
		if(balanceAmount.compareTo(BigDecimal.ZERO) < 0) {
			String errMsg = "Payment Error: Amount entered " + amountTendered + currency + " is lesser than the total price of " + 
					product.getProductDescription().getDescription() + " " + priceWithTax + currency;
			throw new InvalidPaymentException(errMsg);
		}
		System.out.println("Cash Payment Is Successful");
		printReceipt(amountTendered, balanceAmount);
	}

}
