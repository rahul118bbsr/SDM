/**
 * 
 */
package main.com.sdm.server.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import main.com.sdm.common.util.RegionHelper;
import main.com.sdm.server.tax.taxrules.TaxCalculationAdapterEnum;
import main.com.sdm.server.tax.taxrules.model.TaxTypeModel;

/**
 * A utility class which has various helper functions related to tax
 * 
 * @author Rahul Dev Mishra, Aleesha Mishra
 * @assignment Assignment 7  
 * @date 26-Oct-2016 12:13:52 PM
 *
 */
public class TaxCalculationHelper {
	private TaxCalculationHelper(){}
	
	/**
	 * Fetch the list of tax types that are applicable for a region.
	 * 
	 * @return - list of taxes
	 */
	public static List<TaxTypeModel> fetchAllTaxTypes() {
		String region = RegionHelper.fetchRegion();
		return TaxCalculationAdapterEnum.valueOf(region).getTaxCalculationAdapter().fetchAllTaxTypes();
	}
	
	/**
	 * Calculates the absolute price of the product including the tax
	 * 
	 * @param productPriceWithoutTax - product price sans the tax
	 * @return - price of the product with the taxes applied
	 */
	public static BigDecimal calculatePriceWithTax(BigDecimal productPriceWithoutTax) {
		BigDecimal totaltaxPercentage = calculateTotaltax(fetchAllTaxTypes());
		return productPriceWithoutTax.add(totaltaxPercentage.divide(new BigDecimal("100")).multiply(productPriceWithoutTax))
				.setScale(2, RoundingMode.CEILING);
	}
	
	/**
	 * Calculate the total that would be applied
	 * 
	 * @param taxTypeModelList - list of taxes defines for a region
	 * @return - total tax percentage.
	 */
	public static BigDecimal calculateTotaltax(List<TaxTypeModel> taxTypeModelList) {
		return taxTypeModelList.stream()
				.map(taxTypeModel -> taxTypeModel.getTaxValue())
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
