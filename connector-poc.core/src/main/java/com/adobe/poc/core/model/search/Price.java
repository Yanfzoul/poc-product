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
"price",
"original_price",
"is_discount",
"customer_group_id"
})
public class Price {

@JsonProperty("price")
private String price;
@JsonProperty("original_price")
private String originalPrice;
@JsonProperty("is_discount")
private Boolean isDiscount;
@JsonProperty("customer_group_id")
private String customerGroupId;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("price")
public String getPrice() {
return price;
}

@JsonProperty("price")
public void setPrice(String price) {
this.price = price;
}

@JsonProperty("original_price")
public String getOriginalPrice() {
return originalPrice;
}

@JsonProperty("original_price")
public void setOriginalPrice(String originalPrice) {
this.originalPrice = originalPrice;
}

@JsonProperty("is_discount")
public Boolean getIsDiscount() {
return isDiscount;
}

@JsonProperty("is_discount")
public void setIsDiscount(Boolean isDiscount) {
this.isDiscount = isDiscount;
}

@JsonProperty("customer_group_id")
public String getCustomerGroupId() {
return customerGroupId;
}

@JsonProperty("customer_group_id")
public void setCustomerGroupId(String customerGroupId) {
this.customerGroupId = customerGroupId;
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