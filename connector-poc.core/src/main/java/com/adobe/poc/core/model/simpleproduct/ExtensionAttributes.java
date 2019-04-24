package com.adobe.poc.core.model.simpleproduct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"website_ids",
"category_links",
"stock_item"
})
public class ExtensionAttributes {

@JsonProperty("website_ids")
private List<Integer> websiteIds = null;
@JsonProperty("category_links")
private List<CategoryLink> categoryLinks = null;
@JsonProperty("stock_item")
private StockItem stockItem;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("website_ids")
public List<Integer> getWebsiteIds() {
return websiteIds;
}

@JsonProperty("website_ids")
public void setWebsiteIds(List<Integer> websiteIds) {
this.websiteIds = websiteIds;
}

@JsonProperty("category_links")
public List<CategoryLink> getCategoryLinks() {
return categoryLinks;
}

@JsonProperty("category_links")
public void setCategoryLinks(List<CategoryLink> categoryLinks) {
this.categoryLinks = categoryLinks;
}

@JsonProperty("stock_item")
public StockItem getStockItem() {
return stockItem;
}

@JsonProperty("stock_item")
public void setStockItem(StockItem stockItem) {
this.stockItem = stockItem;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}