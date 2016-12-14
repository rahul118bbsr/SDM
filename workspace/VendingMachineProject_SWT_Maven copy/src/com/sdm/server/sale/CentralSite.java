/**
 * 
 */
package com.sdm.server.sale;

import java.util.Objects;

/**
 * This is a class which gets updated by sale that the process has come to and
 * end.
 * 
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 20, 2016 11:52:12 PM
 * @Project Assignment 5
 */
public class CentralSite {
	private static CentralSite centralSite;

	private CentralSite() {
	}

	public static CentralSite getInstance() {
		if(Objects.isNull(centralSite)) {
			centralSite = new CentralSite();
		}
		return centralSite;
	}

	/**
	 * This method updates the transaction.
	 * 
	 * @param sale
	 */
	public void updateSaleTransaction(Sale sale) {
		System.out.println("Sale transaction succesfully updated to central site.");
	}

}
