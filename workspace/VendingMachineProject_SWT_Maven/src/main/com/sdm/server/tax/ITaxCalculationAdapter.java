/**
 * 
 */
package main.com.sdm.server.tax;

import java.util.List;

import main.com.sdm.server.tax.taxrules.model.TaxTypeModel;

/**
 * Adapter interface which can be plugged in to retrieve taxes from various tax sources  
 * 
 * @author Rahul Dev Mishra, Aleesha Mishra
 * @assignment Assignment 7  
 * @date 26-Oct-2016 10:11:54 AM
 *
 */
public interface ITaxCalculationAdapter {
	
	/**
	 * Dynamically understands the adapter region and fetches the list of taxes for that region
	 * 
	 * @return - a list of taxes
	 */
	List<TaxTypeModel> fetchAllTaxTypes();	

}
