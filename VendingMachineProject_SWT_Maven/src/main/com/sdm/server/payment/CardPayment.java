/**
 * 
 */
package main.com.sdm.server.payment;

import java.math.BigDecimal;

import main.com.sdm.server.sale.Sale;

/**
 * This is a class which is invoked when the user selects the card payment option and payment is done,
 *  receipt is generated.
 *  
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 19, 2016 7:58:52 PM
 * @Project Assignment 5
 */
public class CardPayment extends Payment {

	/**
	 * This method is responsible for user payment by identifying the product with its amount tendered.
	 * 
	 * @param product
	 * @param amountTendered
	 */
	@Override
	public void makePayment(Sale sale, BigDecimal amountTendered) {
		System.out.println("Card Payment Is Successful");
		printReceipt(BigDecimal.ZERO, BigDecimal.ZERO);
	}
}
