/**
 * 
 */
package com.sdm.common.util;

import com.sdm.server.currency.CurrencyEnum;

/**
 * A utility which retrieves the currency for the given region
 * 
 * @author Rahul Dev Mishra, Aleesha Mishra
 * @assignment Assignment 7  
 * @date 27-Oct-2016 9:32:01 AM
 *
 */
public class CurrencyHelper {
	private CurrencyHelper(){}
	
	public static String fetchCurrency() {
		String region = RegionHelper.fetchRegion();
		return CurrencyEnum.valueOf(region).getCurrency();
	}
}