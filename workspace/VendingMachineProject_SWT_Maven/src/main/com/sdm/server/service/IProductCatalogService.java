/**
 * 
 */
package main.com.sdm.server.service;

import java.util.List;

import main.com.sdm.server.product.Product;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 08-Nov-2016 11:41:37 AM
 *
 */
public interface IProductCatalogService {

	List<Product> fetchProductDetailsFromProductCatalog();
	void updateProductQuantCountByMinusOne(Product product);

}
