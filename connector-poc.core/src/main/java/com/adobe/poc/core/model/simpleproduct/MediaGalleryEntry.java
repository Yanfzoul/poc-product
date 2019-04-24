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
"id",
"media_type",
"label",
"position",
"disabled",
"types",
"file"
})
public class MediaGalleryEntry {

@JsonProperty("id")
private Integer id;
@JsonProperty("media_type")
private String mediaType;
@JsonProperty("label")
private Object label;
@JsonProperty("position")
private Integer position;
@JsonProperty("disabled")
private Boolean disabled;
@JsonProperty("types")
private List<String> types = null;
@JsonProperty("file")
private String file;
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

@JsonProperty("media_type")
public String getMediaType() {
return mediaType;
}

@JsonProperty("media_type")
public void setMediaType(String mediaType) {
this.mediaType = mediaType;
}

@JsonProperty("label")
public Object getLabel() {
return label;
}

@JsonProperty("label")
public void setLabel(Object label) {
this.label = label;
}

@JsonProperty("position")
public Integer getPosition() {
return position;
}

@JsonProperty("position")
public void setPosition(Integer position) {
this.position = position;
}

@JsonProperty("disabled")
public Boolean getDisabled() {
return disabled;
}

@JsonProperty("disabled")
public void setDisabled(Boolean disabled) {
this.disabled = disabled;
}

@JsonProperty("types")
public List<String> getTypes() {
return types;
}

@JsonProperty("types")
public void setTypes(List<String> types) {
this.types = types;
}

@JsonProperty("file")
public String getFile() {
return file;
}

@JsonProperty("file")
public void setFile(String file) {
this.file = file;
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