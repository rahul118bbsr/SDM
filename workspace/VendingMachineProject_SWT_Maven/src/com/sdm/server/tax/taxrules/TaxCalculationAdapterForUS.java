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
 * @date 26-Oct-2016 10:58:38 AM
 *
 */
public class TaxCalculationAdapterForUS implements ITaxCalculationAdapter {

	/* (non-Javadoc)
	 * @see com.sdm.server.tax.ITaxCalculationAdapter#calculateTotalTax()
	 */
	@Override
	public List<TaxTypeModel> fetchAllTaxTypes() {
		return TaxRulesEnum.USA.getTaxTypeModelList();
	}

}
