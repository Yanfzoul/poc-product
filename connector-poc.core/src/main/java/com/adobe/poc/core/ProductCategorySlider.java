package com.adobe.poc.core;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;
import com.adobe.poc.core.model.simpleproduct.SearchResult;
import com.adobe.poc.core.model.simpleproduct.SimpleProduct;

public class ProductCategorySlider extends WCMUsePojo {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductCategorySlider.class);
	
	private List<SimpleProduct> products;
		  
    @Override
    public void activate() throws Exception {	
    	SlingHttpServletRequest request = getRequest();
    	String search = request.getParameter("search");
    	String brand = request.getParameter("brand");
    	String color = request.getParameter("color");
    	String priceMin = request.getParameter("priceMin");
    	String priceMax = request.getParameter("priceMax");
    	String categoryId = request.getParameter("categoryId");
 
    	if (search == null) {
    		categoryId = getProperties().get("search", "");
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
    		categoryId = getProperties().get("categoryId", "3");
    	}

        int nbMaxProducts = 10;
        final String nbMaxProduct = getProperties().get("nbMaxProducts", "10");
        if (StringUtils.isNotBlank(nbMaxProduct)) {
        	nbMaxProducts = Integer.valueOf(nbMaxProduct);
        }
        SearchResult result = ProductManager.searchProduct(categoryId, null, nbMaxProducts, null);
        
        if (null != result) {
        	products = result.getItems();
        }
        
    }

	public List<SimpleProduct> getProducts() {
		return products;
	}


}
