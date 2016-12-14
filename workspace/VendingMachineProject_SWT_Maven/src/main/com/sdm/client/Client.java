/**
 * 
 */
package main.com.sdm.client;

import main.com.sdm.server.controller.Authenticator;
import main.com.sdm.server.controller.IAuthenticator;
import main.com.sdm.server.controller.IVendingMachine;
import main.com.sdm.server.controller.VendingMachine;
import main.com.sdm.server.sale.Sale;

/**
 * This class is responsible for building the vending machine user interface.
 * 
 * @author Rahul Dev Mishra
 * @assignment  Assignment 7
 * @date 18-Nov-2016 6:08:40 PM
 *
 */
public class Client {
	
	public void execute() {
		IAuthenticator authenticator = new Authenticator();
		AuthenticationPage authenticationPage = new AuthenticationPage(authenticator);
		
		while(true) {
			authenticationPage.execute();
			displayCatalogPage();
		}
	}
	
	private static void displayCatalogPage() {
		IVendingMachine vendingMachine = new VendingMachine();
		Sale sale = vendingMachine.makeNewSale();
		ClientSaleDisplay clientDisplay = new ClientSaleDisplay(sale, vendingMachine);
		clientDisplay.display();
	}
}
