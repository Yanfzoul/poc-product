package com.adobe.poc.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.poc.core.model.CustomAttributes;
import com.adobe.poc.core.model.ProduitVariant;
import com.adobe.poc.core.model.category.Category;
import com.adobe.poc.core.model.category.ProductCategory;
import com.adobe.poc.core.model.category.all.AllCateg;
import com.adobe.poc.core.model.search.Item;
import com.adobe.poc.core.model.simpleproduct.CustomAttribute;
import com.adobe.poc.core.model.simpleproduct.MediaGalleryEntry;
import com.adobe.poc.core.model.simpleproduct.SearchResult;
import com.adobe.poc.core.model.simpleproduct.SimpleProduct;

/**
 * The Class ProductManager.
 */
public class ProductManager {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductManager.class);

	/** The Constant URL_GENERAL. */
	public static final String URL_GENERAL = "http://ec2-35-181-68-229.eu-west-3.compute.amazonaws.com/index.php";
	
	/** The Constant URL_PRODUCT_MEDIA_CATALOG. */
	public static final String URL_PRODUCT_MEDIA_CATALOG = "media/catalog/product";
	
	/** The Constant URL_CONFIGURABLE_PRODUCT. */
	public static final String URL_CONFIGURABLE_PRODUCT = "/rest/V1/configurable-products/";
	
	/** The Constant URL_PRODUCT. */
	public static final String URL_PRODUCT = "/rest/V1/products/";
	
	/** The Constant URL_PRODUCT. */
	public static final String URL_PRODUCT_SEARCH = "/rest/V1/products?";
	
	/** The Constant URL_CATEGORY. */
	public static final String URL_CATEGORY = "/rest/V1/categories/";
	
	/** The Constant URL_CATEGORY_PRODUCTS. */
	public static final String URL_CATEGORY_PRODUCTS = "/products";
	
	/** The Constant URL_CATEGORY_LIST. */
	public static final String URL_CATEGORY_LIST = "/rest/V1/categories";
	
	/** The Constant URL_ADMIN. */
	public static final String URL_ADMIN = "/admin/";
	
	/** The Constant THUMBNAIL. */
	public static final String THUMBNAIL = "thumbnail";
	
	/** The Constant IMAGE. */
	public static final String IMAGE = "image";
	
	/** The Constant SMALL_IMAGE. */
	public static final String SMALL_IMAGE = "small_image";
	
	/** The Constant SWATCH_IMAGE. */
	public static final String SWATCH_IMAGE = "swatch_image";
	
	/** The Constant URL_BASE_IMAGE. */
	public static final String URL_BASE_IMAGE = "http://ec2-35-181-68-229.eu-west-3.compute.amazonaws.com/pub/media/catalog/product";
	
	public static final String PARAM_AND = "&";
	
	public static final String PARAM_SEARCH_CRITERIA = "searchCriteria";
	
	public static final String PARAM_PAGE_SIZE = "searchCriteria[pageSize]=";
	
	public static final String PARAM_SEARCH_FILTERS = "filters";
	
	public static final String PARAM_SEARCH_GROUP = "filter_groups";
	
	public static final String PARAM_CATEGORY_ID = "category_id";
	
	public static final String PARAM_SKU = "sku";
	
	public static final String PARAM_FIELD = "field";
	
	public static final String PARAM_VALUE = "value";
	
	public static final String PARAM_NAME = "name";
	
	public static final String PARAM_CONDITION_TYPE = "condition_type";
	
	public static final String PARAM_CONDITION_EQ = "eq";
	
	public static final String PARAM_CONDITION_LIKE = "like";
	
	public static final String PARAM_BRACKET_OPEN = "[";
	
	public static final String PARAM_BRACKET_CLOSE = "]";
	
	public static final String PARAM_EQUAL = "=";
	
	public static final String PARAM_NAME_SEPARATOR = "%25";
	
	/**
	 * Gets the configurable product.
	 *
	 * @param productSKU the product SKU
	 * @return the configurable product
	 */
	public static String getConfigurableProduct(String productSKU) {
		String output = null;
		output = NetClientGet.callServiceByGetCached(URL_GENERAL + URL_CONFIGURABLE_PRODUCT + productSKU + "/children", NetClientGet.TOKEN);
		return output;
	}

	/**
	 * Gets the list product from SKU.
	 *
	 * @param sku the sku
	 * @return the list product from SKU
	 */
	/*
	 * public static String getAdminCredential() throws IOException { final String
	 * POST_PARAMS = "{\n" + "\"username\": CGI_admin,\r\n" +
	 * "    \"password\": Cultura@123 \n}"; String output =
	 * NetClientGet.callServiceByPost(URL_GENERAL + URL_ADMIN, POST_PARAMS); return
	 * output; }
	 */
	public static List<ProduitVariant> getListProductFromSKU(final String sku) {
		// SKU de test : "gouache_linel"
		final String reponseCusto = getConfigurableProduct(sku);
		List<ProduitVariant> products = null;
		if (StringUtils.isNotBlank(reponseCusto)) {
			products = JsonConverterUtils.convertJsonStringToListObject(reponseCusto, ProduitVariant.class);
			for (ProduitVariant product : products) {
				for (CustomAttributes customAttr : product.getCustom_attributes()) {
					updateImageUrl(customAttr);
				}
			}
		}

		return products;
	}

	/**
	 * Gets the skus from variant.
	 *
	 * @param sku the sku
	 * @return the skus from variant
	 */
	public static String getSkusFromVariant(final String sku) {
		String skusVariant = "";
		List<ProduitVariant> products = getListProductFromSKU(sku);
		if (null != products) {
			for (ProduitVariant variant : products) {
				skusVariant += variant.getSku() + ",";
			}
		}
		// If not null, delete last ,
		if (StringUtils.isNotBlank(skusVariant)) {
			skusVariant = skusVariant.substring(0, skusVariant.length() - 1);
		}
		return skusVariant;
	}

	/**
	 * Update url of image attributes.
	 *
	 * @param customAttr the custom attr
	 */
	public static void updateImageUrl(CustomAttributes customAttr) {
		switch (customAttr.getAttribute_code()) {
		case THUMBNAIL:
		case IMAGE:
		case SMALL_IMAGE:
		case SWATCH_IMAGE:
			customAttr.getValue().set(0, URL_BASE_IMAGE + customAttr.getValue().get(0));
		default:
			break;
		}
	}
	
	/**
	 * Update url of image attributes.
	 *
	 * @param customAttr the custom attr
	 */
	public static void updateImageUrlCustomAttribute(CustomAttribute customAttr) {
		switch (customAttr.getAttributeCode()) {
		case THUMBNAIL:
		case IMAGE:
		case SMALL_IMAGE:
		case SWATCH_IMAGE:
			customAttr.getValue().set(0, URL_BASE_IMAGE + customAttr.getValue().get(0));
		default:
			break;
		}
	}
	
	
	/**
	 * Update url of image attributes.
	 *
	 * @param customAttr the custom attr
	 */
	public static void updateImageUrlItem(Item item) {
		if (StringUtils.isNotBlank(item.getImage())) {
			item.setImage(URL_BASE_IMAGE + item.getImage());
		}
	}
	/**
	 * Update url of image attributes.
	 *
	 * @param mediaGalleryEntry the media gallery entry
	 */
	public static void updateImageUrlForMediaEntry(MediaGalleryEntry mediaGalleryEntry) {
		if (StringUtils.isNotBlank(mediaGalleryEntry.getFile())) {
			mediaGalleryEntry.setFile(URL_BASE_IMAGE + mediaGalleryEntry.getFile());
		}
	}

	/**
	 * Gets the product.
	 *
	 * @param productSKU the product SKU
	 * @return the product
	 */
	public static String getProduct(String productSKU) {
		String output = null;
		output = NetClientGet.callServiceByGetCached(URL_GENERAL + URL_PRODUCT + productSKU, NetClientGet.TOKEN);
		return output;
	}

	/**
	 * Gets the category.
	 *
	 * @param categoryId the category id
	 * @return the category
	 */
	public static String getCategory(String categoryId) {
		String output = null;
		output = NetClientGet.callServiceByGetCached(URL_GENERAL + URL_CATEGORY + categoryId, NetClientGet.TOKEN);
		return output;
	}

	/**
	 * Gets the category product.
	 *
	 * @param categoryId the category id
	 * @return the category product
	 */
	public static String getCategoryProduct(String categoryId) {
		String output = null;
		output = NetClientGet.callServiceByGetCached(URL_GENERAL + URL_CATEGORY + categoryId + URL_CATEGORY_PRODUCTS, NetClientGet.TOKEN);
		return output;
	}

	/**
	 * Gets the category list.
	 *
	 * @return the category list
	 */
	public static String getCategoryList() {
		String output = null;
		output = NetClientGet.callServiceByGetCached(URL_GENERAL + URL_CATEGORY_LIST, NetClientGet.TOKEN);
		return output;
	}

	/**
	 * Gets the type product from SKU.
	 *
	 * @param sku the sku
	 * @return the type product from SKU
	 */
	public static String getTypeProductFromSKU(final String sku) {
		// SKU de test : "gouache_linel"
		String typeId = "";
		final String reponseCusto = getProduct(sku);
		if (StringUtils.isNotBlank(reponseCusto)) {
			try {
				JSONObject json = new JSONObject(reponseCusto);
				typeId = (String) json.get("type_id");
			} catch (JSONException e) {
				LOGGER.error("Error while getting Type Product From SKU", e);
			}
		}

		return typeId;
	}

	/**
	 * Gets the simple product from sku.
	 *
	 * @param sku the sku
	 * @return the simple product from sku
	 */
	public static SimpleProduct getSimpleProductFromSku(final String sku) {
		// id de test : product_dynamic_681
		SimpleProduct simpleProduct = null;
		final String reponseCusto = getProduct(sku);
		if (StringUtils.isNotBlank(reponseCusto)) {
			simpleProduct = JsonConverterUtils.convertJsonStringToObject(reponseCusto, SimpleProduct.class);
		}

		return simpleProduct;
	}

	/**
	 * Gets the category from id.
	 *
	 * @param categoryId the category id
	 * @return the category from id
	 */
	public static Category getCategoryFromId(final String categoryId) {
		// id de test : 3 (Livres)
		Category category = null;
		final String reponseCusto = getCategory(categoryId);
		if (StringUtils.isNotBlank(reponseCusto)) {
			category = JsonConverterUtils.convertJsonStringToObject(reponseCusto, Category.class);
		}

		return category;
	}

	/**
	 * Gets the products in category from id.
	 *
	 * @param categoryId the category id
	 * @param maxProduct the max product
	 * @return the products in category from id
	 */
	public static List<SimpleProduct> getProductsInCategoryFromId(final String categoryId, final int maxProduct) {
		// id de test : 3 (Livres)
		List<ProductCategory> productCategory = null;
		List<SimpleProduct> simpleProducts = null;
		final String reponseCusto = getCategoryProduct(categoryId);
		if (StringUtils.isNotBlank(reponseCusto)) {
			productCategory = JsonConverterUtils.convertJsonStringToListObject(reponseCusto, ProductCategory.class);
			if (null != productCategory && productCategory.size() > 0) {
				simpleProducts = new ArrayList<SimpleProduct>();
				int counter = 0;
				for (ProductCategory product : productCategory) {
					if (counter < maxProduct) {
						SimpleProduct simpleProduct = getSimpleProductFromSku(product.getSku());
						if (null != simpleProduct && null != simpleProduct.getMediaGalleryEntries()) {
							for (MediaGalleryEntry mediaEntry : simpleProduct.getMediaGalleryEntries()) {
								updateImageUrlForMediaEntry(mediaEntry);
							}
						}
						for (CustomAttribute customAttr : simpleProduct.getCustomAttributes()) {
							updateImageUrlCustomAttribute(customAttr);
						}
						simpleProducts.add(simpleProduct);
						counter++;
					}
					// for (CustomAttributes customAttr : product.getCustom_attributes()) {
					// updateImageUrl(customAttr);
					// }
				}
			}
		}

		return simpleProducts;
	}
	
	/**
	 * Gets the products in category from id with page.
	 *
	 * @param categoryId the category id
	 * @param maxProduct the max product
	 * @param page the page
	 * @return the products in category from id
	 */
	public static List<SimpleProduct> getProductsInCategoryFromIdWithPage(final String categoryId, final int maxProduct, final int page) {
		// id de test : 3 (Livres)
		List<ProductCategory> productCategory = null;
		List<SimpleProduct> simpleProducts = null;
		final String reponseCusto = getCategoryProduct(categoryId);
		if (StringUtils.isNotBlank(reponseCusto)) {
			productCategory = JsonConverterUtils.convertJsonStringToListObject(reponseCusto, ProductCategory.class);
			if (null != productCategory && productCategory.size() > 0) {
				simpleProducts = new ArrayList<SimpleProduct>();
				int counter = 0;
				int nbPages = productCategory.size() / maxProduct;
				int start = productCategory.size() - 1 / maxProduct;
				if (start < 0) {
					start = 0;
				}
				counter = start;
				int end = nbPages * maxProduct;
				while (counter < end) {
					ProductCategory product = productCategory.get(counter);
					SimpleProduct simpleProduct = getSimpleProductFromSku(product.getSku());
					if (null != simpleProduct && null != simpleProduct.getMediaGalleryEntries()) {
						for (MediaGalleryEntry mediaEntry : simpleProduct.getMediaGalleryEntries()) {
							updateImageUrlForMediaEntry(mediaEntry);
						}
					}
					for (CustomAttribute customAttr : simpleProduct.getCustomAttributes()) {
						updateImageUrlCustomAttribute(customAttr);
					}
					simpleProducts.add(simpleProduct);
					counter++;
				}
			}
		}

		return simpleProducts;
	}

	/**
	 * Gets the list categories.
	 *
	 * @return the list categories
	 */
	public static List<AllCateg> getListCategories() {
		// id de test : 3 (Livres)
		List<AllCateg> categories = null;
		CopyOnWriteArrayList<AllCateg> lst = new CopyOnWriteArrayList<AllCateg>();
		final String reponseCusto = getCategoryList();
		if (StringUtils.isNotBlank(reponseCusto)) {
			
			categories = JsonConverterUtils.convertJsonStringToListObject(reponseCusto, AllCateg.class);
			lst.addAll(categories);
			populateAllCategList(lst, null);
		}
		return lst;
	}
	
	/**
	 * Populate all categ list.
	 *
	 * @param categories the categories
	 * @param childs the childs
	 */
	public static void populateAllCategList(List<AllCateg> categories, List<AllCateg> childs) {
		if (null != childs && !childs.isEmpty()) {
			for (AllCateg child : childs) {
				categories.add(child);
				if (null != child.getChildrenData() && !child.getChildrenData().isEmpty()) {
					populateAllCategList(categories, child.getChildrenData());
				}
			}
		} else {
			for (AllCateg categ : categories) {
				populateAllCategList(categories, categ.getChildrenData());
			}
		}
		
	}
	
	/**
	 * Search product.
	 *
	 * @param categoryId the category id
	 * @param productId the product id
	 * @return the list
	 */
	public static SearchResult searchProduct(final String categoryId, final String productId, final Integer pageSize, final String name) {
		String reponseCusto = null;
		SearchResult searchResult = null;
		final StringBuilder requestUrl = new StringBuilder();
		requestUrl.append(URL_GENERAL);
		requestUrl.append(URL_PRODUCT_SEARCH);
		if (StringUtils.isNotBlank(categoryId)) { 
			requestUrl.append(generateSearchParam(PARAM_FIELD, PARAM_CATEGORY_ID, 0, 0));
			requestUrl.append(PARAM_AND);
			requestUrl.append(generateSearchParam(PARAM_VALUE, categoryId, 0, 0));
			requestUrl.append(PARAM_AND);
			requestUrl.append(generateSearchParam(PARAM_CONDITION_TYPE, PARAM_CONDITION_EQ, 0, 0));
			requestUrl.append(PARAM_AND);
		}
		if ( StringUtils.isNotBlank(productId)) {
			requestUrl.append(generateSearchParam(PARAM_FIELD, PARAM_SKU, 0, 0));
			requestUrl.append(PARAM_AND);
			requestUrl.append(generateSearchParam(PARAM_VALUE, productId, 0, 0));
			requestUrl.append(PARAM_AND);
			requestUrl.append(generateSearchParam(PARAM_CONDITION_TYPE, PARAM_CONDITION_EQ, 0, 0));
		}
		if (StringUtils.isNotBlank(name)) { 
			requestUrl.append(generateSearchParam(PARAM_FIELD, PARAM_NAME, 0, 0));
			requestUrl.append(PARAM_AND);
			requestUrl.append(generateSearchParam(PARAM_VALUE, PARAM_NAME_SEPARATOR + name + PARAM_NAME_SEPARATOR, 0, 0));
			requestUrl.append(PARAM_AND);
			requestUrl.append(generateSearchParam(PARAM_CONDITION_TYPE, PARAM_CONDITION_LIKE, 0, 0));
			requestUrl.append(PARAM_AND);
		}
		if (null != pageSize) {
			requestUrl.append(PARAM_AND);
			requestUrl.append(PARAM_PAGE_SIZE);
			requestUrl.append(pageSize.intValue());
		}
		reponseCusto = NetClientGet.callServiceByGetCached(requestUrl.toString(), NetClientGet.TOKEN);
		if (StringUtils.isNotBlank(reponseCusto)) {
			searchResult = JsonConverterUtils.convertJsonStringToObject(reponseCusto, SearchResult.class);
			for (SimpleProduct simpleProduct : searchResult.getItems()) {
				if (null != simpleProduct && null != simpleProduct.getMediaGalleryEntries()) {
					for (MediaGalleryEntry mediaEntry : simpleProduct.getMediaGalleryEntries()) {
						updateImageUrlForMediaEntry(mediaEntry);
					}
				}
				for (CustomAttribute customAttr : simpleProduct.getCustomAttributes()) {
					updateImageUrlCustomAttribute(customAttr);
				}
			}
		}
		
		return searchResult;
	}
	
	/**
	 * Generate search param.
	 *	ex : searchCriteria[filter_groups][<index>][filters][<index>][field]=<field_name>
	 * @param type the type
	 * @param value the value
	 * @param condition the condition
	 * @param counterGroup the counter group
	 * @param counterFilter the counter filter
	 * @return the string
	 */
	private static String generateSearchParam (final String type, final String value, int counterGroup, int counterFilter) {
		final StringBuilder searchParam = new StringBuilder();
		searchParam.append(PARAM_SEARCH_CRITERIA);// searchCriteria
		searchParam.append(PARAM_BRACKET_OPEN); // [
		searchParam.append(PARAM_SEARCH_GROUP); // filter_groups
		searchParam.append(PARAM_BRACKET_CLOSE); // ]
		searchParam.append(PARAM_BRACKET_OPEN); // [
		searchParam.append(counterGroup);
		searchParam.append(PARAM_BRACKET_CLOSE); // ]
		searchParam.append(PARAM_BRACKET_OPEN); // [
		searchParam.append(PARAM_SEARCH_FILTERS); // filters
		searchParam.append(PARAM_BRACKET_CLOSE); // ]
		searchParam.append(PARAM_BRACKET_OPEN); // [
		searchParam.append(counterFilter);
		searchParam.append(PARAM_BRACKET_CLOSE); // ]
		searchParam.append(PARAM_BRACKET_OPEN); // [
		searchParam.append(type);
		searchParam.append(PARAM_BRACKET_CLOSE); // ]
		searchParam.append(PARAM_EQUAL); // =
		searchParam.append(value);
		
		return searchParam.toString();
	}
	
}
