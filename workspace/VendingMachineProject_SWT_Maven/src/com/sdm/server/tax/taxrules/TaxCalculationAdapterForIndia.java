/**
 * 
 */
package com.sdm.server.tax.taxrules;

import java.util.List;

import com.sdm.server.tax.ITaxCalculationAdapter;
import com.sdm.server.tax.taxrules.model.TaxTypeModel;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 26-Oct-2016 11:52:25 AM
 *
 */
public class TaxCalculationAdapterForIndia implements ITaxCalculationAdapter{

	@Override
	public List<TaxTypeModel> fetchAllTaxTypes() {
		return TaxRulesEnum.INDIA.getTaxTypeModelList();
	}
	
}
