/**
 * 
 */
package main.com.sdm.common.currency;

/**
 * This class holds the currency type for different regions.
 * 
 * @author Rahul Dev Mishra, Aleesha Mishra
 * @assignment Assignment 7 
 * @date 27-Oct-2016 9:30:07 AM
 *
 */
public enum CurrencyEnum {
	INDIA("INR"),
	USA("USD"),
	UK("GBP"),
	EURO("EURO"),
	SAUDI("SAR");
	
	private String currency;
	
	private CurrencyEnum(String currency) {
		this.currency = currency;
	}
	
	public String getCurrency() {
		return currency;
	}

}
