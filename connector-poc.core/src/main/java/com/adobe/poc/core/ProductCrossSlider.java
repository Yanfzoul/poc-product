package com.adobe.poc.core;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;
import com.adobe.poc.core.model.search.Events;
import com.adobe.poc.core.model.search.Facets;
import com.adobe.poc.core.model.search.Item;
import com.adobe.poc.core.model.search.ResultSearch;
import com.adobe.poc.core.model.simpleproduct.SimpleProduct;

public class ProductCrossSlider extends WCMUsePojo {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductCrossSlider.class);
	
	private List<SimpleProduct> products;
	
	private List<Item> productsFromSearch;
	
	private Facets facets;
	
	private Events events;
		  
    @Override
    public void activate() throws Exception {	
    	String sku = getProperties().get("sku", String.class);
    	if (sku == null) {
    		sku = getRequest().getRequestPathInfo().getSelectorString();
    	}
    	
    	if (StringUtils.isNotBlank(sku)) {
	        ResultSearch resultSearch = SearchManager.searchElasticCross(sku);
	        
	        if (null != resultSearch) {
	        	productsFromSearch = resultSearch.getProducts().getItems();
	        	facets = resultSearch.getFacets();
	        	events = resultSearch.getEvents();
	        	LOGGER.info(facets.getCategoryId().size() + "CATEGORY SIZE");
	        	LOGGER.info("productsFromSearch.size() : " + productsFromSearch.size());
	        }
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
