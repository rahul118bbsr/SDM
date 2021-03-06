/**
 * 
 */
package main.com.sdm.server.dao;

import java.util.Date;

import org.bson.Document;

import main.com.sdm.common.util.RegionHelper;
import main.com.sdm.server.constants.TransactionsColumnConstants;
import main.com.sdm.server.product.Product;
import main.com.sdm.server.product.ProductDescription;
import main.com.sdm.server.sale.Receipt;
import main.com.sdm.server.sale.Sale;
import main.com.sdm.server.tax.taxrules.model.TaxTypeModel;
import main.com.sdm.server.util.DaoHelper;
import main.com.sdm.server.util.UserHelper;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 23-Nov-2016 11:15:01 AM
 *
 */
public class TransactionsDao implements ITransactionsDao {

	/* (non-Javadoc)
	 * @see main.com.sdm.server.dao.ITransactionsDao#save(main.com.sdm.server.sale.Sale)
	 */
	@Override
	public void save(Sale sale) {
		Product product = sale.getProduct();
		ProductDescription productDescription = product.getProductDescription();
		Receipt receipt = sale.getPayment().getReceipt();
		String taxesApplied = "";
		
		for(TaxTypeModel taxTypeModel : sale.getTaxModel().getTaxTypeModelList()) {
			taxesApplied = taxesApplied.concat(taxTypeModel.getTaxName()).concat(":").concat(taxTypeModel.getTaxValue().toString());
			taxesApplied = taxesApplied.concat("    ");
		}
		
		Document document = new Document(TransactionsColumnConstants.PRODUCT_ID,  productDescription.getProductId())
				.append(TransactionsColumnConstants.PRODUCT_NAME, productDescription.getDescription())
				.append(TransactionsColumnConstants.PRODUCT_PRICE, sale.getTaxModel().getProductPriceIncludingTax().toString())
				.append(TransactionsColumnConstants.AMOUNT_TENDERED, receipt.getTenderedAmount().toString())
				.append(TransactionsColumnConstants.BALANCE_AMOUNT, receipt.getBalanceAmount().toString())
				.append(TransactionsColumnConstants.PAYMENT_TYPE, sale.getPayment().getPaymentType())
				.append(TransactionsColumnConstants.TAXES_APPLIED, taxesApplied.trim())
				.append(TransactionsColumnConstants.REGION, RegionHelper.fetchRegion())
				.append(TransactionsColumnConstants.USER, UserHelper.getInstance().getUserName())
				.append(TransactionsColumnConstants.DATE, new Date());
		
		DaoHelper.fetchTransactionsCollection().insertOne(document);
	}

}
