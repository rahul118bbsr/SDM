/**
 * 
 */
package com.sdm.common.exception;

/**
 * This is an Exception class which is thrown when the user exceeds the allowed purchase limit.
 * 
 * @author Rahul Dev Mishra, Aleesha Mishra
 * @assignment Assignment 7  
 * @date 21-Oct-2016 1:12:01 PM
 *
 */
public class PurchaseLimitExceeded extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public PurchaseLimitExceeded(String message) {
		super(message);
	}


}
