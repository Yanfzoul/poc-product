package com.adobe.poc.core;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;
import com.adobe.poc.core.model.simpleproduct.SearchResult;
import com.adobe.poc.core.model.simpleproduct.SimpleProduct;

public class ProductCategorySlider extends WCMUsePojo {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductCategorySlider.class);
	
	private String lowerCaseTitle;
	private String lowerCaseDescription;
	private String reponseCusto = null;
	private List<SimpleProduct> products;
	private String typeProduct = null;
	
	  
    @Override
    public void activate() throws Exception {
        lowerCaseTitle = "test titre"; //getProperties().get("title", "").toLowerCase();
        lowerCaseDescription = "test description"; //getProperties().get("description", "").toLowerCase();
        String categoryId = getRequest().getRequestPathInfo().getSelectorString();
        if (StringUtils.isBlank(categoryId)) {
        	categoryId = getProperties().get("categoryId", "3");
        }
        int nbMaxProducts = 10;
        final String nbMaxProduct = getProperties().get("nbMaxProducts", "10");
        if (StringUtils.isNotBlank(nbMaxProduct)) {
        	nbMaxProducts = Integer.valueOf(nbMaxProduct);
        }
        SearchResult result = ProductManager.searchProduct(categoryId, null, nbMaxProducts);
        
        if (null != result) {
        	products = result.getItems();
        }
        
    }
    
    public String getLowerCaseTitle() {
        return lowerCaseTitle;
    }
  
    public String getLowerCaseDescription() {
        return lowerCaseDescription;
    }
    
    public String getReponseCusto() {
        return reponseCusto;
    }

	public List<SimpleProduct> getProducts() {
		return products;
	}

	public String getTypeProduct() {
		return typeProduct;
	}

}
