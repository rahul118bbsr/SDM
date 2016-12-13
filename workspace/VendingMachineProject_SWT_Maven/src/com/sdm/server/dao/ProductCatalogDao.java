/**
 * 
 */
package com.sdm.server.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.sdm.server.constants.ProductCatalogColumnConstants;
import com.sdm.server.util.DaoHelper;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 08-Nov-2016 11:38:02 AM
 *
 */
public class ProductCatalogDao implements IProductCatalogDao {

	/* (non-Javadoc)
	 * @see com.sdm.server.dao.IProductCatalog#fetchProductCatalog()
	 */
	@Override
	public List<Document> fetchProductCatalog() {
		return DaoHelper.fetchProductCatalogCollection().find().into(new ArrayList<>());
	}
	
	@Override
	public void updateProductQuantCountByMinusOne(String productId) {
		Bson filter = Filters.eq(ProductCatalogColumnConstants.PRODUCT_ID, productId);
		Bson update = Updates.inc(ProductCatalogColumnConstants.QUANTITY, -1);
		DaoHelper.fetchProductCatalogCollection().updateOne(filter, update);
	}

}
