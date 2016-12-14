/**
 * 
 */
package main.com.sdm.server.enums;

import java.math.BigDecimal;

import main.com.sdm.server.product.Product;
import main.com.sdm.server.product.ProductDescription;

/**
 * This is like the warehouse of the vending machine. This stores all the product details and this is what the user sees when
 * the user come to the vending machine to make a purchase
 * 
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 19, 2016 6:53:46 PM
 * @Project Assignment 5
 */
public enum ProductCatalogEnum {
	A1("A1", "5000", "Casio Men's MQ24-1E Black Resin Watch", 2),
	A2("A2", "15000", "Rolex Men's 118238 Day-Date Gold Watch", 2),
	B1("B1", "2500", "Jstyle Gold Male Chain Necklace for Men", 2),
	B2("B2", "3500", "Halukakah Men's 18k Stamp Real Gold Necklace", 2),
	C1("C1", "4560", "Rolex Cosmograph Daytona Ice Blue Watch", 2),
	C2("C2", "5509", "Montegrappa Sylvester Stallone Pen", 2);
	
	private Product product;
	
	ProductCatalogEnum(String productId, String price, String description, int quantity){
		ProductDescription productDescription = new ProductDescription(productId, new BigDecimal(price), description);
		product = new Product(productDescription, quantity);
	}
	
	public Product getProduct() {
		return product;
	}
}
