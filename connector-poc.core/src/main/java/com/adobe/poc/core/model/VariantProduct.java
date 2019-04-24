package com.adobe.poc.core.model;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;
import com.adobe.poc.core.ProductManager;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VariantProduct extends WCMUsePojo {
	private static final Logger LOGGER = LoggerFactory.getLogger(VariantProduct.class);
	
	private String lowerCaseTitle;
	private String lowerCaseDescription;
	private String reponseCusto = null;
	private List<ProduitVariant> variants;
	private ProduitVariant productItem;
	
	private static final String URL_PRODUCT = "https://mag506.adobedemo.com/media/catalog/product";
	private static final String THUMBNAIL = "thumbnail";
	private static final String IMAGE = "image";
	private static final String SMALL_IMAGE = "small_image";
	private static final String SWATCH_IMAGE = "swatch_image";
	  
    @Override
    public void activate() throws Exception {
        lowerCaseTitle = "test titre"; //getProperties().get("title", "").toLowerCase();
        lowerCaseDescription = "test description"; //getProperties().get("description", "").toLowerCase();
        
        reponseCusto = ProductManager.getConfigurableProduct("gouache_linel");
        if (StringUtils.isNotBlank(reponseCusto)) {
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
	        variants = mapper.readValue(reponseCusto,new TypeReference<List<ProduitVariant>>(){});
	        LOGGER.error("list : " + variants);
	        for (ProduitVariant product : variants) {
	        	LOGGER.error("productid : " + product.getId());
	        	for (CustomAttributes customAttr : product.getCustom_attributes()) {
	        		updateImageUrl(customAttr);
	        	}
	        }
	        if (null != variants && variants.size() > 0) {
	        	productItem = variants.get(0);
	        }
        }
    }
    
    /**
     * Update url of image attributes
     * @param customAttr
     */
    private void updateImageUrl (CustomAttributes customAttr) {
    	switch (customAttr.getAttribute_code()) {
			case THUMBNAIL :
			case IMAGE :
			case SMALL_IMAGE :
			case SWATCH_IMAGE : customAttr.getValue().set(0, URL_PRODUCT + customAttr.getValue().get(0));
			default :break;
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

	public List<ProduitVariant> getVariants() {
		return variants;
	}

	public ProduitVariant getProductItem() {
		return productItem;
	}

}
