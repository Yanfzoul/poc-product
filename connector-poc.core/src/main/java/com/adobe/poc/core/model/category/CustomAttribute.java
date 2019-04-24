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
"attribute_code",
"value"
})
public class CustomAttribute {

@JsonProperty("attribute_code")
private String attributeCode;
@JsonProperty("value")
private List<String> value;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("attribute_code")
public String getAttributeCode() {
return attributeCode;
}

@JsonProperty("attribute_code")
public void setAttributeCode(String attributeCode) {
this.attributeCode = attributeCode;
}

@JsonProperty("value")
public List<String> getValue() {
return value;
}

@JsonProperty("value")
public void setValue(List<String> value) {
this.value = value;
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