package com.adobe.configurableproduct.core;

import org.junit.Assert;
import org.junit.Test;

import com.adobe.poc.core.SearchManager;

// PROXY CGI -Dhttp.proxyHost=10.83.124.3 -Dhttp.proxyPort=3128
public class SearchManagerTest {

	@Test
	public void searchPocTest() {
		final String result = SearchManager.searchPocTest();
		System.out.println(result);
		Assert.assertNotNull(result, "test fail");
	}
	
	@Test
	public void searchTest() {
		final String result = SearchManager.search("blanche");
		System.out.println(result);
		Assert.assertNotNull(result, "test fail");
	}
	
}
