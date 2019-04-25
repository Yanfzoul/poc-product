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
"products",
"categories",
"events",
"buckets",
"facets"
})
public class ResultSearch {

@JsonProperty("products")
private Products products;
@JsonProperty("categories")
private Categories categories;
@JsonProperty("events")
private Events events;
@JsonProperty("buckets")
private List<Bucket> buckets = null;
@JsonProperty("facets")
private Facets facets;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("products")
public Products getProducts() {
return products;
}

@JsonProperty("products")
public void setProducts(Products products) {
this.products = products;
}

@JsonProperty("categories")
public Categories getCategories() {
return categories;
}

@JsonProperty("categories")
public void setCategories(Categories categories) {
this.categories = categories;
}

@JsonProperty("events")
public Events getEvents() {
return events;
}

@JsonProperty("events")
public void setEvents(Events events) {
this.events = events;
}

@JsonProperty("buckets")
public List<Bucket> getBuckets() {
return buckets;
}

@JsonProperty("buckets")
public void setBuckets(List<Bucket> buckets) {
this.buckets = buckets;
}

@JsonProperty("facets")
public Facets getFacets() {
return facets;
}

@JsonProperty("facets")
public void setFacets(Facets facets) {
this.facets = facets;
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