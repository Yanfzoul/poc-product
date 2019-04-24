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
"filter_groups"
})
public class SearchCriteria {

@JsonProperty("filter_groups")
private List<FilterGroup> filterGroups = null;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("filter_groups")
public List<FilterGroup> getFilterGroups() {
return filterGroups;
}

@JsonProperty("filter_groups")
public void setFilterGroups(List<FilterGroup> filterGroups) {
this.filterGroups = filterGroups;
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