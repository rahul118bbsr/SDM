/**
 * 
 */
package main.com.sdm.server.tax.taxrules.model;

import java.math.BigDecimal;

/**
 * This model class holds the design of the tax type model. 
 * 
 * @author Rahul Dev Mishra, Aleesha Mishra
 * @assignment Assignment 7  
 * @date 26-Oct-2016 11:18:54 AM
 *
 */
public class TaxTypeModel {
	private String region;
	private String taxName;
	private BigDecimal taxValue;
	
	public TaxTypeModel(String region, String taxName, BigDecimal taxValue) {
		super();
		this.region = region;
		this.taxName = taxName;
		this.taxValue = taxValue;
	}
	
	public String getRegion() {
		return region;
	}
	
	public String getTaxName() {
		return taxName;
	}
	
	public BigDecimal getTaxValue() {
		return taxValue;
	}
}
