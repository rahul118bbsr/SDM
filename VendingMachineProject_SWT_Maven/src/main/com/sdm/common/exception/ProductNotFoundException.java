/**
 * 
 */
package main.com.sdm.common.exception;

/**
 * This is an Exception class which is thrown when the user selects a product which is out of stock.
 * 
 * @author Rahul Dev Mishra, Aleesha Mishra
 * @assignment Assignment 7  
 * @date 21-Oct-2016 1:12:01 PM
 *
 */
public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public ProductNotFoundException(String message) {
		super(message);
	}


}
