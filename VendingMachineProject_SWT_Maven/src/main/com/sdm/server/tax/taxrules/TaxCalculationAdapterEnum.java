/**
 * 
 */
package main.com.sdm.server.tax.taxrules;

import main.com.sdm.server.tax.ITaxCalculationAdapter;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 26-Oct-2016 3:34:40 PM
 *
 */
public enum TaxCalculationAdapterEnum {
	INDIA(new TaxCalculationAdapterForIndia()),
	USA(new TaxCalculationAdapterForUS()),
	UK(new TaxCalculationAdapterForUK()),
	EURO(new TaxCalculationAdapterForEuro()),
	SAUDI(new TaxCalculationAdapterForSaudi());
	
	private ITaxCalculationAdapter taxCalculationAdapter;
	TaxCalculationAdapterEnum(ITaxCalculationAdapter taxCalculationAdapter) {
		this.taxCalculationAdapter = taxCalculationAdapter;
	}
	
	public ITaxCalculationAdapter getTaxCalculationAdapter() {
		return taxCalculationAdapter;
	}

}
