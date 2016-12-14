/**
 * 
 */
package main.com.sdm.server.controller;

import main.com.sdm.common.exception.IdAuthneticationException;

/**
 * This class authenticates the user id that is scanned at the vending machine
 * 
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 19, 2016 6:33:48 PM
 * @Project Assignment 5
 */

public interface IAuthenticator {
	/**
	 * This is an interface method to verify the user with its authentication process.
	 * 
	 * @param id - the user id
	 * @throws IdAuthneticationException - when the authentication fails
	 */
	void authenticateId(String id) throws IdAuthneticationException;

}
