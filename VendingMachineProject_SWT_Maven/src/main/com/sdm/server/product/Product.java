/**
 * 
 */
package main.com.sdm.server.product;

/**
 * This class hold the product details which the user is purchasing.
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 19, 2016 6:49:26 PM
 * @Project Assignment 5
 */
public class Product {
	private ProductDescription productDescription;
	private int quantity;
	
	public Product(ProductDescription productDescription) {
		this.productDescription = productDescription;
	}
	
	public Product(ProductDescription productDescription, int quantity) {
		this.productDescription = productDescription;
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "Product Details: " + productDescription;
	}
	
	public ProductDescription getProductDescription() {
		return productDescription;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
