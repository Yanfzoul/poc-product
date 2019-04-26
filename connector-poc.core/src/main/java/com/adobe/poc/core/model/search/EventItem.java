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
"libelle",
"dates",
"lieu"
})
public class EventItem {

@JsonProperty("id")
private String id;
@JsonProperty("libelle")
private String libelle;
@JsonProperty("dates")
private List<String> dates = null;
@JsonProperty("lieu")
private String lieu;
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

@JsonProperty("libelle")
public String getLibelle() {
return libelle;
}

@JsonProperty("libelle")
public void setLibelle(String libelle) {
this.libelle = libelle;
}

@JsonProperty("dates")
public List<String> getDates() {
return dates;
}

@JsonProperty("dates")
public void setDates(List<String> dates) {
this.dates = dates;
}

@JsonProperty("lieu")
public String getLieu() {
return lieu;
}

@JsonProperty("lieu")
public void setLieu(String lieu) {
this.lieu = lieu;
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