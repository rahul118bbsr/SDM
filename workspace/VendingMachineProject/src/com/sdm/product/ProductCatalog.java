/**
 * 
 */
package com.sdm.product;

import java.util.EnumMap;
import java.util.Objects;

import com.sdm.enums.ProductCatalogEnum;

/**
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 19, 2016 7:15:01 PM
 * @Project Assignment 5
 */
public class ProductCatalog {
	private static EnumMap<ProductCatalogEnum, Product> productCatalogMap = new EnumMap<>(ProductCatalogEnum.class);
	private static ProductCatalog productCatalog;
	
	private ProductCatalog() {
		if(Objects.nonNull(productCatalog)) {
			throw new IllegalAccessError("Cannot create multiple objects of this singleton class!!!");
		}
	}
	
	public static ProductCatalog getInstance() {
		if(Objects.isNull(productCatalog)) {
			productCatalog = new ProductCatalog();
		}
		
		return productCatalog;
	}
	
	public static void initProductCatalog(){
		for(ProductCatalogEnum productCatalogEnum : ProductCatalogEnum.values()) {
			productCatalogMap.put(productCatalogEnum, productCatalogEnum.getProduct());
		}
	}
	
	public static void displayCatalog() {
		System.out.println("Following products are currently available in the catalog");
		for(ProductCatalogEnum productCatalogEnum : ProductCatalogEnum.values()) {
			ProductDescription productDescription = productCatalogEnum.getProduct().getProductDescription();
//			String print = String.format("%1$-10s %2$-10s %3$.2f", str, str1, bd);
			String displayStr = String.format("%1$-10s %2$-20s %3$10s\n", productDescription.getProductId(), productDescription.getDescription(), 
					productDescription.getPrice());
			System.out.println(productDescription.getProductId() + "\t\t\t" +  productDescription.getDescription() + "\t\t\t$" 
			+ productDescription.getPrice() + "\t\t\t");
//			System.out.println(displayStr);
		}
	}
	
	public static EnumMap<ProductCatalogEnum, Product> getProductCatalogMap() {
		return productCatalogMap;
	}
	
}
