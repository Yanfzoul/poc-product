package com.adobe.poc.core.model.search;
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
"id",
"sku",
"name",
"description",
"image",
"categories",
"prices",
"is_in_stock"
})
public class Item {

@JsonProperty("id")
private String id;
@JsonProperty("sku")
private List<String> sku = null;
@JsonProperty("name")
private String name;
@JsonProperty("description")
private String description;
@JsonProperty("image")
private String image;
@JsonProperty("categories")
private List<Category> categories = null;
@JsonProperty("prices")
private List<Price> prices = null;
@JsonProperty("is_in_stock")
private Boolean isInStock;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("sku")
public List<String> getSku() {
return sku;
}

@JsonProperty("sku")
public void setSku(List<String> sku) {
this.sku = sku;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("description")
public String getDescription() {
return description;
}

@JsonProperty("description")
public void setDescription(String description) {
this.description = description;
}

@JsonProperty("image")
public String getImage() {
return image;
}

@JsonProperty("image")
public void setImage(String image) {
this.image = image;
}

@JsonProperty("categories")
public List<Category> getCategories() {
return categories;
}

@JsonProperty("categories")
public void setCategories(List<Category> categories) {
this.categories = categories;
}

@JsonProperty("prices")
public List<Price> getPrices() {
return prices;
}

@JsonProperty("prices")
public void setPrices(List<Price> prices) {
this.prices = prices;
}

@JsonProperty("is_in_stock")
public Boolean getIsInStock() {
return isInStock;
}

@JsonProperty("is_in_stock")
public void setIsInStock(Boolean isInStock) {
this.isInStock = isInStock;
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