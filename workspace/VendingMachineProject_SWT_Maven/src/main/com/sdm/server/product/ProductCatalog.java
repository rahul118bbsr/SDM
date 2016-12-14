/**
 * 
 */
package main.com.sdm.server.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import main.com.sdm.server.service.IProductCatalogService;
import main.com.sdm.server.service.ProductCatalogService;

/**
 * This is a class which initiates the catalog and displays it ti the user for
 * purchase. This class is singleton instance class.
 * 
 * @author Aleesha Mishra, Rahul Dev Mishra
 * @date Oct 19, 2016 7:15:01 PM
 * @Project Assignment 5
 */
public class ProductCatalog {
	private static Map<String, Product> productCatalogMap = new HashMap<>();
	private static ProductCatalog productCatalog;

	private ProductCatalog() {
		if (Objects.nonNull(productCatalog)) {
			throw new IllegalAccessError("Cannot create multiple objects of this singleton class!!!");
		}
	}

	/**
	 * This is a singleton instance.
	 * 
	 * @return
	 */
	public static ProductCatalog getInstance() {
		if (Objects.isNull(productCatalog)) {
			productCatalog = new ProductCatalog();
		}
		return productCatalog;
	}

	/**
	 * In here, in this method the enum catalog is initiated.
	 */
	public static void initProductCatalog() {
		fetchProductCatalog();
	}

	/**
	 * This method displays the catalog to the user for purchase.
	 */
	public static List<Product> fetchProductCatalog() {
		IProductCatalogService productCatalogService = new ProductCatalogService();
		List<Product> productList = productCatalogService.fetchProductDetailsFromProductCatalog();
		productCatalogMap = productList.stream()
				.collect(Collectors.toMap(x -> x.getProductDescription().getProductId(), x -> x));
		return productList;
	}

	public static Map<String, Product> getProductCatalogMap() {
		return productCatalogMap;
	}

}
