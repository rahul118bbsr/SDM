/**
 * 
 */
package com.sdm.enums;

import java.math.BigDecimal;

import com.sdm.product.Product;
import com.sdm.product.ProductDescription;

/**
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 19, 2016 6:53:46 PM
 * @Project Assignment 5
 */
public enum ProductCatalogEnum {
	A1("A1", "5000", "Casio Men's MQ24-1E Black Resin Watch"),
	A2("A2", "15000", "Rolex Men's 118238 Day-Date Gold Watch"),
	B1("B1", "2500", "Jstyle Gold Male Chain Necklace for Men"),
	B2("B2", "3500", "Halukakah Men's 18k Stamp Real Gold Necklace"),
	C1("C1", "4560", "Rolex Cosmograph Daytona Ice Blue Watch"),
	C2("C2", "5509", "Montegrappa Sylvester Stallone Pen");
	
	private Product product;
	
	ProductCatalogEnum(String productId, String price, String description){
		ProductDescription productDescription = new ProductDescription(productId, new BigDecimal(price), description);
		product = new Product(productDescription);
	}
	
	public Product getProduct() {
		return product;
	}
}
