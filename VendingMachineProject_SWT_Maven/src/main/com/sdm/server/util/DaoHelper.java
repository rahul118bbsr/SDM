/**
 * 
 */
package main.com.sdm.server.util;

import java.util.Objects;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import main.com.sdm.server.constants.MongoCollectionConstants;

/**
 * @author Rahul Dev Mishra
 * @assignment
 * @date 07-Nov-2016 11:26:09 PM
 *
 */
public class DaoHelper {
	private static final String DATABASE_NAME = "VM";
	private static final MongoClient CLIENT = new MongoClient();
	private static MongoCollection<Document> userCollection = null;
	private static MongoCollection<Document> productCatalogCollection = null;
	private static MongoCollection<Document> TransactionsCollection = null;

	private DaoHelper() {
	}

	private static MongoDatabase fetchDatabase() {
		return CLIENT.getDatabase(DATABASE_NAME);
	}

	public static MongoCollection<Document> fetchUserCollection() {
		if (Objects.isNull(userCollection)) {
			userCollection = fetchDatabase().getCollection(MongoCollectionConstants.USERS_COLLECTION);
		}
		return userCollection;
	}
	
	public static MongoCollection<Document> fetchProductCatalogCollection() {
		if (Objects.isNull(productCatalogCollection)) {
			productCatalogCollection = fetchDatabase().getCollection(MongoCollectionConstants.PRODUCT_CATALOG_COLLECTION);
		}
		return productCatalogCollection;
	}
	
	public static MongoCollection<Document> fetchTransactionsCollection() {
		if (Objects.isNull(TransactionsCollection)) {
			TransactionsCollection = fetchDatabase().getCollection(MongoCollectionConstants.TRANSACTIONS_COLLECTION);
		}
		return TransactionsCollection;
	}
}
