package com.adobe.poc.core;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;
import com.adobe.poc.core.model.search.Events;
import com.adobe.poc.core.model.search.Facets;
import com.adobe.poc.core.model.search.Item;
import com.adobe.poc.core.model.search.ResultSearch;
import com.adobe.poc.core.model.simpleproduct.SearchResult;
import com.adobe.poc.core.model.simpleproduct.SimpleProduct;

public class ProductCategorySlider extends WCMUsePojo {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductCategorySlider.class);
	
	private List<SimpleProduct> products;
	
	private List<Item> productsFromSearch;
	
	private Facets facets;
	
	private Events events;
		  
    @Override
    public void activate() throws Exception {	
    	SlingHttpServletRequest request = getRequest();
    	String search = request.getParameter("search");
    	String brand = request.getParameter("brand");
    	String color = request.getParameter("color");
    	String priceMin = request.getParameter("priceMin");
    	String priceMax = request.getParameter("priceMax");
    	String[] categoryId = request.getParameterValues("categoryId");
 
    	if (search == null) {
    		search = getProperties().get("search", "");
    	}
    	
    	if (brand == null) {
    		brand = getProperties().get("brand", "");
    	}
    	
    	if (color == null) {
    		color = getProperties().get("color", "");
    	}
    	
    	if (priceMin == null) {
    		priceMin = getProperties().get("priceMin", "");
    	}
    	
    	if (priceMax == null) {
    		priceMax = getProperties().get("priceMax", "");
    	}
    	
    	if (categoryId == null) {
    		categoryId = getProperties().get("categoryId", new String[0]);
    	}
    	
    	for (String str : categoryId)
    		LOGGER.info("TEST CATEGORIES" + str);
    	
    	LOGGER.info("search : " + search + " brand " + brand + " color " + color + " priceMin " + priceMin + " priceMax " + priceMax + " categoryId " + categoryId);

        final String nbMaxProduct = getProperties().get("nbMaxProducts", "10");
        //SearchResult result = ProductManager.searchProduct(categoryId, null, nbMaxProducts, null);
        
        ResultSearch resultSearch = SearchManager.searchElastic(search, nbMaxProduct, categoryId, priceMin, priceMax, color, brand);
        
//        if (null != result) {
//        	products = result.getItems();
//        }
        if (null != resultSearch) {
        	productsFromSearch = resultSearch.getProducts().getItems();
        	facets = resultSearch.getFacets();
        	events = resultSearch.getEvents();
        	LOGGER.info(facets.getCategoryId().size() + "CATEGORY SIZE");
        	LOGGER.info("productsFromSearch.size() : " + productsFromSearch.size());
        }
        
    }

	public List<SimpleProduct> getProducts() {
		return products;
	}
	
	public List<Item> getProductsFromSearch() {
		return productsFromSearch;
	}

	public Facets getFacets() {
		return facets;
	}
	
	public Events getEvents() {
		return events;
	}

}
