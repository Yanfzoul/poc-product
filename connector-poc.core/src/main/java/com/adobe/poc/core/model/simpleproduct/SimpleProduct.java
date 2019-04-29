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
"sku",
"name",
"description",
"attribute_set_id",
"price",
"status",
"visibility",
"type_id",
"created_at",
"updated_at",
"weight",
"extension_attributes",
"product_links",
"options",
"media_gallery_entries",
"tier_prices",
"custom_attributes"
})
public class SimpleProduct {

@JsonProperty("id")
private Integer id;
@JsonProperty("sku")
private String sku;
@JsonProperty("name")
private String name;
@JsonProperty("description")
private String description;
@JsonProperty("attribute_set_id")
private Integer attributeSetId;
@JsonProperty("price")
private Double price;
@JsonProperty("status")
private Integer status;
@JsonProperty("visibility")
private Integer visibility;
@JsonProperty("type_id")
private String typeId;
@JsonProperty("created_at")
private String createdAt;
@JsonProperty("updated_at")
private String updatedAt;
@JsonProperty("weight")
private Integer weight;
@JsonProperty("extension_attributes")
private ExtensionAttributes extensionAttributes;
@JsonProperty("product_links")
private List<Object> productLinks = null;
@JsonProperty("options")
private List<Object> options = null;
@JsonProperty("media_gallery_entries")
private List<MediaGalleryEntry> mediaGalleryEntries = null;
@JsonProperty("tier_prices")
private List<Object> tierPrices = null;
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

@JsonProperty("sku")
public String getSku() {
return sku;
}

@JsonProperty("sku")
public void setSku(String sku) {
this.sku = sku;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("description")
public String getDescription() {
return description;
}

@JsonProperty("description")
public void setId(String description) {
this.description = description;
}

@JsonProperty("attribute_set_id")
public Integer getAttributeSetId() {
return attributeSetId;
}

@JsonProperty("attribute_set_id")
public void setAttributeSetId(Integer attributeSetId) {
this.attributeSetId = attributeSetId;
}

@JsonProperty("price")
public Double getPrice() {
return price;
}

@JsonProperty("price")
public void setPrice(Double price) {
this.price = price;
}

@JsonProperty("status")
public Integer getStatus() {
return status;
}

@JsonProperty("status")
public void setStatus(Integer status) {
this.status = status;
}

@JsonProperty("visibility")
public Integer getVisibility() {
return visibility;
}

@JsonProperty("visibility")
public void setVisibility(Integer visibility) {
this.visibility = visibility;
}

@JsonProperty("type_id")
public String getTypeId() {
return typeId;
}

@JsonProperty("type_id")
public void setTypeId(String typeId) {
this.typeId = typeId;
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

@JsonProperty("weight")
public Integer getWeight() {
return weight;
}

@JsonProperty("weight")
public void setWeight(Integer weight) {
this.weight = weight;
}

@JsonProperty("extension_attributes")
public ExtensionAttributes getExtensionAttributes() {
return extensionAttributes;
}

@JsonProperty("extension_attributes")
public void setExtensionAttributes(ExtensionAttributes extensionAttributes) {
this.extensionAttributes = extensionAttributes;
}

@JsonProperty("product_links")
public List<Object> getProductLinks() {
return productLinks;
}

@JsonProperty("product_links")
public void setProductLinks(List<Object> productLinks) {
this.productLinks = productLinks;
}

@JsonProperty("options")
public List<Object> getOptions() {
return options;
}

@JsonProperty("options")
public void setOptions(List<Object> options) {
this.options = options;
}

@JsonProperty("media_gallery_entries")
public List<MediaGalleryEntry> getMediaGalleryEntries() {
return mediaGalleryEntries;
}

@JsonProperty("media_gallery_entries")
public void setMediaGalleryEntries(List<MediaGalleryEntry> mediaGalleryEntries) {
this.mediaGalleryEntries = mediaGalleryEntries;
}

@JsonProperty("tier_prices")
public List<Object> getTierPrices() {
return tierPrices;
}

@JsonProperty("tier_prices")
public void setTierPrices(List<Object> tierPrices) {
this.tierPrices = tierPrices;
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