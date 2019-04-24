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
"items",
"search_criteria",
"total_count"
})
public class SearchResult {

@JsonProperty("items")
private List<SimpleProduct> items = null;
@JsonProperty("search_criteria")
private SearchCriteria searchCriteria;
@JsonProperty("total_count")
private Integer totalCount;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("items")
public List<SimpleProduct> getItems() {
return items;
}

@JsonProperty("items")
public void setItems(List<SimpleProduct> items) {
this.items = items;
}

@JsonProperty("search_criteria")
public SearchCriteria getSearchCriteria() {
return searchCriteria;
}

@JsonProperty("search_criteria")
public void setSearchCriteria(SearchCriteria searchCriteria) {
this.searchCriteria = searchCriteria;
}

@JsonProperty("total_count")
public Integer getTotalCount() {
return totalCount;
}

@JsonProperty("total_count")
public void setTotalCount(Integer totalCount) {
this.totalCount = totalCount;
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