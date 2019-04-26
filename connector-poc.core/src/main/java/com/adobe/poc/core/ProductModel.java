package com.adobe.poc.core;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;
import com.adobe.poc.core.model.simpleproduct.SimpleProduct;

public class ProductModel extends WCMUsePojo {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductModel.class);
	
	private SimpleProduct product;
		  
    @Override
    public void activate() throws Exception {	
    	String sku = getRequest().getRequestPathInfo().getSelectorString();
    	if (StringUtils.isNotBlank(sku)) {
    		product = ProductManager.getSimpleProductFromSku(sku);
    	}
    	
    }

	public SimpleProduct getProduct() {
		return product;
	}
	
}
