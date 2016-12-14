/**
 * 
 */
package main.com.sdm.client.listener;

import main.com.sdm.server.sale.Sale;

/**
 * This interface aids in implementing the Observer pattern. All the subscribers will have to implement this interface.
 * 
 * @author Rahul Dev Mishra, Aleesha Mishra
 * @assignment Assignment 7 
 * @date 18-Nov-2016 6:39:29 PM
 *
 */
public interface PropertyListener {
	/**
	 * This method is invoked before the sale is executed.
	 * 
	 * @param sale - non null
	 */
	void onPropertyEventBeforeSale(Sale sale);
	
	/**
	 * Publisher will fire this event after the sale is executed
	 * 
	 * @param sale - non null
	 */
	void onPropertyEventAfterSale(Sale sale);
}
