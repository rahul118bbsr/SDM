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
 * @date 26-Oct-2016 11:54:05 AM
 *
 */
public class TaxCalculationAdapterForEuro implements ITaxCalculationAdapter {

	/* (non-Javadoc)
	 * @see com.sdm.tax.ITaxCalculationAdapter#calculateTotalTax()
	 */
	@Override
	public List<TaxTypeModel> fetchAllTaxTypes() {
		return TaxRulesEnum.EURO.getTaxTypeModelList();
	}
}
