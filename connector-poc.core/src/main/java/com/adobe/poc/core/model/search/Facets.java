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
"category_id",
"brand",
"color"
})
public class Facets {

@JsonProperty("category_id")
private List<CategoryId> categoryId = null;
@JsonProperty("brand")
private List<Brand> brand = null;
@JsonProperty("color")
private List<Color> color = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("category_id")
public List<CategoryId> getCategoryId() {
return categoryId;
}

@JsonProperty("category_id")
public void setCategoryId(List<CategoryId> categoryId) {
this.categoryId = categoryId;
}

@JsonProperty("brand")
public List<Brand> getBrand() {
return brand;
}

@JsonProperty("brand")
public void setBrand(List<Brand> brand) {
this.brand = brand;
}

@JsonProperty("color")
public List<Color> getColor() {
return color;
}

@JsonProperty("color")
public void setColor(List<Color> color) {
this.color = color;
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