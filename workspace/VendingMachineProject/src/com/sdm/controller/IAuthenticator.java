/**
 * 
 */
package com.sdm.controller;

import com.sdm.exception.IdAuthneticationException;

/**
 * 
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 19, 2016 6:33:48 PM
 * @Project Assignment 5
 */

public interface IAuthenticator {
	void authenticateId(String id) throws IdAuthneticationException;

}
