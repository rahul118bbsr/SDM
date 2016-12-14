/**
 * 
 */
package main.com.sdm.server.tax.taxrules;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import main.com.sdm.server.tax.taxrules.model.TaxTypeModel;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 26-Oct-2016 11:12:26 AM
 *
 */
public enum TaxRulesEnum {
	INDIA("INDIA", "VAT:12, CESS:2, GST:5"),
	USA("USA", "GST:6.5"),
	UK("UK", "VAT:9, LUXURY TAX:14.4, LOCAL TAX:2.1"),
	EURO("EURO", "LUXURY TAX:7, LOCAL TAX:1.8"),
	SAUDI("SAUDI", "TAX:0");
	
	private String region;
	private List<TaxTypeModel> taxTypeModelList;
	
	private TaxRulesEnum(String region, String taxes) {
		this.region = region;
		this.taxTypeModelList = formatTaxesIntoList(region, taxes);
	}

	private List<TaxTypeModel> formatTaxesIntoList(String region, String taxes) {
		List<TaxTypeModel> taxTypeModelsList = new ArrayList<>();
		String[] taxArr = taxes.trim().split(",");
		for(String taxVal : taxArr) {
			String[] tax = taxVal.split(":");
			TaxTypeModel taxTypeModel = new TaxTypeModel(region, tax[0].trim(), new BigDecimal(tax[1].trim()));
			taxTypeModelsList.add(taxTypeModel);
		}
		return taxTypeModelsList;
	}
	
	public List<TaxTypeModel> getTaxTypeModelList() {
		return taxTypeModelList;
	}
	
	public String getRegion() {
		return region;
	}
	
}
