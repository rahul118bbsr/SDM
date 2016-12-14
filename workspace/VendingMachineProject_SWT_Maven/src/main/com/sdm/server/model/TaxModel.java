/**
 * 
 */
package main.com.sdm.server.model;

import java.math.BigDecimal;
import java.util.List;

import main.com.sdm.server.tax.taxrules.model.TaxTypeModel;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 18-Nov-2016 6:48:00 PM
 *
 */
public class TaxModel {
	private List<TaxTypeModel> taxTypeModelList;
	private BigDecimal productPriceIncludingTax;
	
	public void setTaxTypeModelList(List<TaxTypeModel> taxTypeModelList) {
		this.taxTypeModelList = taxTypeModelList;
	}
	
	public List<TaxTypeModel> getTaxTypeModelList() {
		return taxTypeModelList;
	}
	
	public void setProductPriceIncludingTax(BigDecimal tax) {
		this.productPriceIncludingTax = tax;
	}
	
	public BigDecimal getProductPriceIncludingTax() {
		return productPriceIncludingTax;
	}

}
