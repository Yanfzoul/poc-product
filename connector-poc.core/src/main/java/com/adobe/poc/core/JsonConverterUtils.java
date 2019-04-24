package com.adobe.poc.core;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverterUtils {
	public static <T> List<T> convertJsonStringToListObject(final String stringToConvert, Class<T> classe) {
		List<T> result = null; 
		
		ObjectMapper mapper = new ObjectMapper();
		JavaType collectionType = mapper.getTypeFactory().constructCollectionType(List.class, classe);
		
	        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
	        try {
				result = mapper.readValue(stringToConvert,collectionType);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    return result;
	}
	
	public static <T> T convertJsonStringToObject(final String stringToConvert, Class<T> classe) {
		T result = null; 
		ObjectMapper mapper = new ObjectMapper();
	        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
	        try {
				result = mapper.readValue(stringToConvert,classe);
			} catch (IOException e) {
				e.printStackTrace();
			}
	    return result;
	}
}
