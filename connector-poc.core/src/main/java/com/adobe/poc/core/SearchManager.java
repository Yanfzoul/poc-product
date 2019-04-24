package com.adobe.poc.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class SearchManager.
 */
public class SearchManager {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(SearchManager.class);

	/** The Constant URL_GENERAL. */
	public static final String URL_GENERAL = "http://51.83.67.120:30600/rest/api/";
	
	/** The Constant URL_PRODUCT_MEDIA_CATALOG. */
	public static final String URL_POC_TEST = "submit-job/PocTestEs";
	
	public static final String URL_SEARCH = "submit-job/RetailAggregateSearch";
	
	public static final String URL_SEARCH_COMPLETE = "http://ec2-35-181-68-229.eu-west-3.compute.amazonaws.com/search/search.php";
	
	public static final String PARAMETER_START_STRING = "?";
	
	public static final String PARAMETER_NAME = "name=";
	
	/**
	 * Search poc test.
	 *
	 * @return the string
	 */
	public static String searchPocTest() {
		String output = null;
		output = NetClientGet.callServiceByGet(URL_GENERAL + URL_POC_TEST + PARAMETER_START_STRING, null);
		return output;
	}
	
	/**
	 * Search poc test.
	 *
	 * @return the string
	 */
	public static String search(final String searchTerm) {
		String output = null;
		output = NetClientGet.callServiceByGet(URL_GENERAL + URL_SEARCH + PARAMETER_START_STRING + PARAMETER_NAME + searchTerm, null);
		return output;
	}
	
	/**
	 * Search poc test.
	 *
	 * @return the string
	 */
	public static String searchComplete(final String searchTerm, final String categSearch) {
		String output = null;
		output = NetClientGet.callServiceByGet(URL_GENERAL + URL_SEARCH + PARAMETER_START_STRING + PARAMETER_NAME + searchTerm, null);
		return output;
	}

}
