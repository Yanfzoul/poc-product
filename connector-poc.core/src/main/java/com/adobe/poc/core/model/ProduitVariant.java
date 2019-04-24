package com.adobe.poc.core.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProduitVariant {
	private long id;
	private String sku;
	private String name;
	private long attribute_set_id;
	private Double price;
	private int status;
	private String type_id;
	private String created_at;
	private String updated_at;
	private Integer weight;
	private Integer visibility;
	private List<String> product_links;
	private List<Double> tier_prices;
	private List<CustomAttributes> custom_attributes;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<CustomAttributes> getCustom_attributes() {
		return custom_attributes;
	}

	public void setCustom_attributes(List<CustomAttributes> custom_attributes) {
		this.custom_attributes = custom_attributes;
	}

	public String getType_id() {
		return type_id;
	}

	public void setType_id(String type_id) {
		this.type_id = type_id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public String getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}

	public long getAttribute_set_id() {
		return attribute_set_id;
	}

	public void setAttribute_set_id(long attribute_set_id) {
		this.attribute_set_id = attribute_set_id;
	}

	public List<String>  getProduct_links() {
		return product_links;
	}

	public void setProduct_links(List<String>  product_links) {
		this.product_links = product_links;
	}

	public List<Double> getTier_prices() {
		return tier_prices;
	}

	public void setTier_prices(List<Double> tier_prices) {
		this.tier_prices = tier_prices;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getVisibility() {
		return visibility;
	}

	public void setVisibility(Integer visibility) {
		this.visibility = visibility;
	}

}
