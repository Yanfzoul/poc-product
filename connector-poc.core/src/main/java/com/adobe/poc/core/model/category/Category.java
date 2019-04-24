package com.adobe.poc.core.model.category;
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
"children",
"created_at",
"updated_at",
"path",
"available_sort_by",
"include_in_menu",
"custom_attributes"
})
public class Category {

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
@JsonProperty("children")
private String children;
@JsonProperty("created_at")
private String createdAt;
@JsonProperty("updated_at")
private String updatedAt;
@JsonProperty("path")
private String path;
@JsonProperty("available_sort_by")
private List<Object> availableSortBy = null;
@JsonProperty("include_in_menu")
private Boolean includeInMenu;
@JsonProperty("custom_attributes")
private List<CustomAttribute> customAttributes = null;
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

@JsonProperty("children")
public String getChildren() {
return children;
}

@JsonProperty("children")
public void setChildren(String children) {
this.children = children;
}

@JsonProperty("created_at")
public String getCreatedAt() {
return createdAt;
}

@JsonProperty("created_at")
public void setCreatedAt(String createdAt) {
this.createdAt = createdAt;
}

@JsonProperty("updated_at")
public String getUpdatedAt() {
return updatedAt;
}

@JsonProperty("updated_at")
public void setUpdatedAt(String updatedAt) {
this.updatedAt = updatedAt;
}

@JsonProperty("path")
public String getPath() {
return path;
}

@JsonProperty("path")
public void setPath(String path) {
this.path = path;
}

@JsonProperty("available_sort_by")
public List<Object> getAvailableSortBy() {
return availableSortBy;
}

@JsonProperty("available_sort_by")
public void setAvailableSortBy(List<Object> availableSortBy) {
this.availableSortBy = availableSortBy;
}

@JsonProperty("include_in_menu")
public Boolean getIncludeInMenu() {
return includeInMenu;
}

@JsonProperty("include_in_menu")
public void setIncludeInMenu(Boolean includeInMenu) {
this.includeInMenu = includeInMenu;
}

@JsonProperty("custom_attributes")
public List<CustomAttribute> getCustomAttributes() {
return customAttributes;
}

@JsonProperty("custom_attributes")
public void setCustomAttributes(List<CustomAttribute> customAttributes) {
this.customAttributes = customAttributes;
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