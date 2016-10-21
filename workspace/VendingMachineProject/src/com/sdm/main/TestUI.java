/**
 * 
 */
package com.sdm.main;

import java.math.BigDecimal;
import java.util.Scanner;

import com.sdm.controller.Authenticator;
import com.sdm.controller.IAuthenticator;
import com.sdm.controller.IVendingMachine;
import com.sdm.controller.VendingMachine;
import com.sdm.enums.PaymentEnum;
import com.sdm.exception.IdAuthneticationException;
import com.sdm.product.ProductCatalog;

/**
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 20, 2016 10:23:48 PM
 * @Project Assignment 5
 */
public class TestUI {
	private static Scanner scanner;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProductCatalog.initProductCatalog();
		scanner = new Scanner(System.in);
		IVendingMachine vendingMachine = null;
		IAuthenticator authenticator = null;
		while(true) {
			vendingMachine = new VendingMachine();
			authenticator = new Authenticator();
			System.out.println("Scan ID for authentication:");
			String authId = scanner.nextLine().trim();
			try {
				authenticator.authenticateId(authId);
			} catch(IdAuthneticationException ex) {
				System.out.println(ex.getMessage());
				continue;
			}
			initTransaction(vendingMachine);
		}
	}
	
	private static void initTransaction(IVendingMachine vendingMachine) {
		ProductCatalog.displayCatalog();
		System.out.println("\nEnter the product id to purchase an item: ");
		String inputProductId = scanner.nextLine();
		vendingMachine.makeNewSale(inputProductId);
		System.out.println("\nAre you sure you want to purchase product " + inputProductId + ". Press Y to confirm or N to cancel");
		String decision = scanner.nextLine().toUpperCase();
		if("Y".equals(decision)) {
			System.out.println("Please pay to purchase the item");
			PaymentEnum.displayPaymentModes();
			System.out.println("\nEnter the payment mode: ");
			String paymentModeInput = scanner.nextLine().toUpperCase();
			if(PaymentEnum.CASH.getPaymentTypeStr().equals(paymentModeInput)) {
				System.out.println("Please enter the cash amount:");
				BigDecimal amountTendered = new BigDecimal(scanner.nextLine());
				vendingMachine.endSale(paymentModeInput, amountTendered);
			} else {
				vendingMachine.endSale(paymentModeInput, BigDecimal.ZERO);
			}
		} else {
			System.out.println("Sale transaction is cancelled.");
		}
		System.out.println("\n");
	}
}
