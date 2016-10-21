/**
 * 
 */
package com.sdm.product;

/**
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 19, 2016 6:49:26 PM
 * @Project Assignment 5
 */
public class Product {
	private ProductDescription productDescription;
	
	@Override
	public String toString() {
		return "Product Details: " + productDescription;
	}

	public Product(ProductDescription productDescription) {
		this.productDescription = productDescription;
	}
	
	public ProductDescription getProductDescription() {
		return productDescription;
	}
}
