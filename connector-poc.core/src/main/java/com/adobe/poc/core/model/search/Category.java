package com.adobe.poc.core.model.search;
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
"category_id",
"is_virtual",
"is_parent",
"name"
})
public class Category {

@JsonProperty("category_id")
private Integer categoryId;
@JsonProperty("is_virtual")
private String isVirtual;
@JsonProperty("is_parent")
private Boolean isParent;
@JsonProperty("name")
private String name;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("category_id")
public Integer getCategoryId() {
return categoryId;
}

@JsonProperty("category_id")
public void setCategoryId(Integer categoryId) {
this.categoryId = categoryId;
}

@JsonProperty("is_virtual")
public String getIsVirtual() {
return isVirtual;
}

@JsonProperty("is_virtual")
public void setIsVirtual(String isVirtual) {
this.isVirtual = isVirtual;
}

@JsonProperty("is_parent")
public Boolean getIsParent() {
return isParent;
}

@JsonProperty("is_parent")
public void setIsParent(Boolean isParent) {
this.isParent = isParent;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
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