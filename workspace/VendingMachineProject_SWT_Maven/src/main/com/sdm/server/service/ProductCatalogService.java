/**
 * 
 */
package main.com.sdm.server.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.bson.Document;

import main.com.sdm.server.constants.ProductCatalogColumnConstants;
import main.com.sdm.server.dao.IProductCatalogDao;
import main.com.sdm.server.dao.ProductCatalogDao;
import main.com.sdm.server.product.Product;
import main.com.sdm.server.product.ProductDescription;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 08-Nov-2016 11:42:28 AM
 *
 */
public class ProductCatalogService implements IProductCatalogService {
	private IProductCatalogDao productCatalogDao;
	
	public ProductCatalogService() {
		this.productCatalogDao = new ProductCatalogDao();
	}

	/* (non-Javadoc)
	 * @see main.com.sdm.server.service.IProductCatalogService#fetchProductsFromProductCatalog()
	 */
	@Override
	public List<Product> fetchProductDetailsFromProductCatalog() {
		List<Document> productDocumentList = productCatalogDao.fetchProductCatalog();
		return productDocumentList.stream()
				.map(doc -> new Product(new ProductDescription(doc.getString(ProductCatalogColumnConstants.PRODUCT_ID), 
						new BigDecimal(doc.getDouble(ProductCatalogColumnConstants.PRICE)),
						doc.getString(ProductCatalogColumnConstants.PRODUCT_DESCRIPTION)), doc.getDouble(ProductCatalogColumnConstants.QUANTITY).intValue()))
				.collect(Collectors.toList());
	}
	
	@Override
	public void updateProductQuantCountByMinusOne(Product product) {
		productCatalogDao.updateProductQuantCountByMinusOne(product.getProductDescription().getProductId());
	}

}
