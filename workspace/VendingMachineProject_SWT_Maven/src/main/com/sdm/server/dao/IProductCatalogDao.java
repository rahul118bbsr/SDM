/**
 * 
 */
package main.com.sdm.server.dao;

import java.util.List;

import org.bson.Document;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 08-Nov-2016 11:34:57 AM
 *
 */
public interface IProductCatalogDao {
	List<Document> fetchProductCatalog();

	void updateProductQuantCountByMinusOne(String productId);
}
