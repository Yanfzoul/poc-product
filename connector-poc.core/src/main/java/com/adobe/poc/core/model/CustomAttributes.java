package com.adobe.poc.core.model;

import java.util.List;

public class CustomAttributes {
	
	private String attribute_code;
	private List<String> value;
	
	public String getAttribute_code() {
		return attribute_code;
	}
	public void setAttribute_code(String attribute_code) {
		this.attribute_code = attribute_code;
	}
	public List<String> getValue() {
		return value;
	}
	public void setValue(List<String> value) {
		this.value = value;
	}
}
