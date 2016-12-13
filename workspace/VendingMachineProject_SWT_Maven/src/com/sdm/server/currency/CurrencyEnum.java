/**
 * 
 */
package com.sdm.server.currency;

/**
 * @author Rahul Dev Mishra
 * @assignment  
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
