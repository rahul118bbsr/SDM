/**
 * 
 */
package main.com.sdm.server.tax.taxrules;

import java.util.List;

import main.com.sdm.server.tax.ITaxCalculationAdapter;
import main.com.sdm.server.tax.taxrules.model.TaxTypeModel;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 26-Oct-2016 11:53:27 AM
 *
 */
public class TaxCalculationAdapterForUK implements ITaxCalculationAdapter {

	@Override
	public List<TaxTypeModel> fetchAllTaxTypes() {
		return TaxRulesEnum.UK.getTaxTypeModelList();
	}

}
