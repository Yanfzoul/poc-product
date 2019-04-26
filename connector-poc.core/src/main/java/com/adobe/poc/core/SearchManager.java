package com.adobe.poc.core;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.poc.core.model.ProduitVariant;
import com.adobe.poc.core.model.search.Item;
import com.adobe.poc.core.model.search.ResultSearch;

// TODO: Auto-generated Javadoc
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
	
	/** The Constant URL_SEARCH. */
	public static final String URL_SEARCH = "submit-job/RetailAggregateSearch";
	
	/** The Constant URL_SEARCH_ELASTIC. */
	public static final String URL_SEARCH_ELASTIC = "http://ec2-35-181-68-229.eu-west-3.compute.amazonaws.com/search/search.php";
	
	/** The Constant PARAMETER_START_STRING. */
	public static final String PARAMETER_START_STRING = "?";
	
	/** The Constant PARAMETER_AND. */
	public static final String PARAMETER_AND = "&";
	
	/** The Constant PARAMETER_NAME. */
	public static final String PARAMETER_NAME = "name=";
	
	/** The Constant PARAMETER_CATEGORY_ID. */
	public static final String PARAMETER_CATEGORY_ID = "category_id=";
	
	/** The Constant PARAMETER_LIMIT. */
	public static final String PARAMETER_LIMIT = "limit=";
	
	/** The Constant PARAMETER_PRICE_MIN. */
	public static final String PARAMETER_PRICE_MIN = "price_min=";
	
	/** The Constant PARAMETER_PRICE_MAX. */
	public static final String PARAMETER_PRICE_MAX = "price_max=";
	
	/** The Constant PARAMETER_COLOR. */
	public static final String PARAMETER_COLOR = "color=";
	
	/** The Constant PARAMETER_BRAND. */
	public static final String PARAMETER_BRAND = "brand=";
	
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
	 * @param searchTerm the search term
	 * @return the string
	 */
	public static String search(final String searchTerm) {
		String output = null;
		output = NetClientGet.callServiceByGet(URL_GENERAL + URL_SEARCH + PARAMETER_START_STRING + PARAMETER_NAME + searchTerm, null);
		return output;
	}
	
	/**
	 * Search elastic.
	 *
	 * @param name the name
	 * @param limit the limit
	 * @param categoryId the category id
	 * @param priceMin the price min
	 * @param priceMax the price max
	 * @param color the color
	 * @param brand the brand
	 * @return the string
	 */
	public static String searchCached(final String name, final String limit, final String categoryId, final String priceMin, final String priceMax, final String color, final String brand) {
		String output = null;
		final StringBuilder query = new StringBuilder();
		query.append(URL_SEARCH_ELASTIC);
		query.append(PARAMETER_START_STRING);
		query.append(generateSearchCriteria(name, PARAMETER_NAME));
		query.append(generateSearchCriteria(limit, PARAMETER_LIMIT));
		query.append(generateSearchCriteria(categoryId, PARAMETER_CATEGORY_ID));
		query.append(generateSearchCriteria(priceMin, PARAMETER_PRICE_MIN));
		query.append(generateSearchCriteria(priceMax, PARAMETER_PRICE_MAX));
		query.append(generateSearchCriteria(color, PARAMETER_COLOR));
		query.append(generateSearchCriteria(brand, PARAMETER_BRAND));
		
		output = NetClientGet.callServiceByGetCached(query.toString(), null);
		return output;
	}
	
	/**
	 * Search elastic.
	 *
	 * @param name the name
	 * @param limit the limit
	 * @param categoryId the category id
	 * @param priceMin the price min
	 * @param priceMax the price max
	 * @param color the color
	 * @param brand the brand
	 * @return the string
	 */
	public static ResultSearch searchElastic(final String name, final String limit, final String categoryId, final String priceMin, final String priceMax, final String color, final String brand) {
		ResultSearch resultSearch = null;
		String output = searchCached(name, limit, categoryId, priceMin, priceMax, color, brand);
		resultSearch = JsonConverterUtils.convertJsonStringToObject(output, ResultSearch.class);
		if (resultSearch != null) {
			for (Item item : resultSearch.getProducts().getItems()) {
				ProductManager.updateImageUrlItem(item);
			}
		}
		return resultSearch;
	}
	
	/**
	 * Generate search criteria.
	 *
	 * @param value the value
	 * @param parameterName the parameter name
	 * @return the string
	 */
	public static String generateSearchCriteria(final String value, final String parameterName) {
		final StringBuilder criteria = new StringBuilder();
		if (StringUtils.isNotBlank(value)) {
			criteria.append(parameterName);
			criteria.append(value);
			criteria.append(PARAMETER_AND);
		}
		return criteria.toString();
	}

}
