package com.adobe.poc.core.model.simpleproduct;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"position",
"category_id"
})
public class CategoryLink {

@JsonProperty("position")
private Integer position;
@JsonProperty("category_id")
private String categoryId;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("position")
public Integer getPosition() {
return position;
}

@JsonProperty("position")
public void setPosition(Integer position) {
this.position = position;
}

@JsonProperty("category_id")
public String getCategoryId() {
return categoryId;
}

@JsonProperty("category_id")
public void setCategoryId(String categoryId) {
this.categoryId = categoryId;
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