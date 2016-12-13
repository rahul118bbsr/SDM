/**
 * 
 */
package com.sdm.server.product;

import java.math.BigDecimal;

/**
 * This class hold the description of all the products in the catalog.
 * 
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 19, 2016 6:40:18 PM
 * @Project Assignment 5
 */
public class ProductDescription {
	private String description;
	private String productId;
	private BigDecimal price;

	public ProductDescription(String productId, BigDecimal price, String description) {
		this.description = description;
		this.productId = productId;
		this.price = price;
	}
	
	@Override
	public String toString() {
		String str = "Product id: " + productId;
		str = str + ", Description: " + description;
		str = str + ", Price: $" + price;
		return str;
	}
	
	public String getDescription() {
		return description;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public String getProductId() {
		return productId;
	}
}
