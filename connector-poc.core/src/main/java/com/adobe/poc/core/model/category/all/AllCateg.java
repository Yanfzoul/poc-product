package com.adobe.poc.core.model.category.all;
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
"parent_id",
"name",
"is_active",
"position",
"level",
"product_count",
"children_data"
})
public class AllCateg{

@JsonProperty("id")
private Integer id;
@JsonProperty("parent_id")
private Integer parentId;
@JsonProperty("name")
private String name;
@JsonProperty("is_active")
private Boolean isActive;
@JsonProperty("position")
private Integer position;
@JsonProperty("level")
private Integer level;
@JsonProperty("product_count")
private Integer productCount;
@JsonProperty("children_data")
private List<AllCateg> childrenData = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("id")
public Integer getId() {
return id;
}

@JsonProperty("id")
public void setId(Integer id) {
this.id = id;
}

@JsonProperty("parent_id")
public Integer getParentId() {
return parentId;
}

@JsonProperty("parent_id")
public void setParentId(Integer parentId) {
this.parentId = parentId;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("is_active")
public Boolean getIsActive() {
return isActive;
}

@JsonProperty("is_active")
public void setIsActive(Boolean isActive) {
this.isActive = isActive;
}

@JsonProperty("position")
public Integer getPosition() {
return position;
}

@JsonProperty("position")
public void setPosition(Integer position) {
this.position = position;
}

@JsonProperty("level")
public Integer getLevel() {
return level;
}

@JsonProperty("level")
public void setLevel(Integer level) {
this.level = level;
}

@JsonProperty("product_count")
public Integer getProductCount() {
return productCount;
}

@JsonProperty("product_count")
public void setProductCount(Integer productCount) {
this.productCount = productCount;
}

@JsonProperty("children_data")
public List<AllCateg> getChildrenData() {
return childrenData;
}

@JsonProperty("children_data")
public void setChildrenData(List<AllCateg> childrenData) {
this.childrenData = childrenData;
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