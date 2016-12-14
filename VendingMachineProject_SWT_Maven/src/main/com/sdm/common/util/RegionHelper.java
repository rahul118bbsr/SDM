/**
 * 
 */
package main.com.sdm.common.util;

import java.util.Objects;

/**
 * A utility that retrieves the region name from the VM argument.
 * 
 * @author Rahul Dev Mishra, Aleesha Mishra
 * @assignment Assignment 7  
 * @date 26-Oct-2016 11:03:42 AM
 *
 */
public class RegionHelper {
	private final static String DEFAULT_REGION = "USA";
	private RegionHelper(){}
	
	/**
	 * Fetches the region name from the VM argument. Defaults to USA if no VM argument is passed.
	 * 
	 * @return - non null region name
	 */
	public static String fetchRegion() {
		String region = System.getProperty("region");
		return (Objects.nonNull(region) && !Objects.equals("", region)) ? region.trim().toUpperCase() : DEFAULT_REGION;
	}
}
