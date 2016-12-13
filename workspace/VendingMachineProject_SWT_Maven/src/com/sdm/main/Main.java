/**
 * 
 */
package com.sdm.main;

import com.sdm.client.Client;
import com.sdm.server.product.ProductCatalog;

/**
 * This is the Main class. This is where everything starts.
 * 
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 20, 2016 10:23:48 PM
 * @Project Assignment 5
 * 
 */
public class Main {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initServer();
		initClient();
	}
	
	private static void initServer() {
		ProductCatalog.initProductCatalog();
	}
	
	private static void initClient() {
		Client client = new Client();
		client.execute();
	}
}
