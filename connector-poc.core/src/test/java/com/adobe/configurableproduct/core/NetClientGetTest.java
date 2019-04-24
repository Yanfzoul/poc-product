package com.adobe.configurableproduct.core;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.adobe.poc.core.ProductManager;
import com.adobe.poc.core.model.category.Category;
import com.adobe.poc.core.model.category.all.AllCateg;
import com.adobe.poc.core.model.simpleproduct.SearchResult;
import com.adobe.poc.core.model.simpleproduct.SimpleProduct;

// PROXY CGI -Dhttp.proxyHost=10.83.124.3 -Dhttp.proxyPort=3128
public class NetClientGetTest {

	@Test
	public void getConfigurableProductTest() {
		final String result = ProductManager.getConfigurableProduct("configurable_product_2");
		System.out.println(result);
		Assert.assertNotNull(result, "test fail");
	}
	
	@Test
	public void getProductTest() {
		final String result = ProductManager.getProduct("product_dynamic_51");
		System.out.println(result);
		Assert.assertNotNull("test fail", result);
	}
	
	@Test
	public void getTypeProductFromSKUTest() {
		final String result = ProductManager.getTypeProductFromSKU("product_dynamic_51");
		System.out.println(result);
		Assert.assertNotNull("test fail", result);
	}
	
	@Test
	public void getSkusFromVariantTest() {
		final String result = ProductManager.getSkusFromVariant("configurable_product_2");
		System.out.println(result);
		Assert.assertNotNull("test fail", result);
	}
	
	@Test
	public void getCategoryFromId() {
		final Category result = ProductManager.getCategoryFromId("3");
		System.out.println(result);
		Assert.assertNotNull("test fail", result);
	}
	
	@Test
	public void getCategoryProductFromIdTest() {
		final List<SimpleProduct> result = ProductManager.getProductsInCategoryFromId("3", 10);
		System.out.println(result);
		Assert.assertNotNull("test fail", result);
	}
	
	@Test
	public void getListCategoriesTest() {
		final List<AllCateg> result = ProductManager.getListCategories();
		System.out.println(result);
		System.out.println(result.size());
		Assert.assertNotNull("test fail", result);
	}
	
	@Test
	public void getSimpleProductFromSkuTest() {
		final SimpleProduct result = ProductManager.getSimpleProductFromSku("product_dynamic_681");
		System.out.println(result);
		Assert.assertNotNull("test fail", result);
	}
	
	@Test
	public void searchProductFromCateg() {
		final SearchResult result = ProductManager.searchProduct("3", null, 10);
		System.out.println("result.getItems().size() : " + result.getItems().size());
		Assert.assertNotNull("test fail", result);
	}
	
	@Test
	public void searchProduct() {
		final SearchResult result = ProductManager.searchProduct(null, "product_dynamic_51", null);
		System.out.println("result.getItems().size() : " + result.getItems().size());
		Assert.assertNotNull("test fail", result);
	}

}
