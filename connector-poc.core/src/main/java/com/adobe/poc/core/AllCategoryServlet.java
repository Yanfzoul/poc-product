package com.adobe.poc.core;

import java.io.IOException;
import java.util.List;

import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.poc.core.ProductManager;
import com.adobe.poc.core.model.category.all.AllCateg;

/**
 * The Class AllCategoryServlet.
 */
@SlingServlet(paths = {"/bin/service/allcategories"}, methods = "GET", metatype=true)
public class AllCategoryServlet extends SlingAllMethodsServlet  {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2817366790081943540L;
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AllCategoryServlet.class);

	/* (non-Javadoc)
	 * @see org.apache.sling.api.servlets.SlingSafeMethodsServlet#doGet(org.apache.sling.api.SlingHttpServletRequest, org.apache.sling.api.SlingHttpServletResponse)
	 */
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
		LOGGER.error("entrée dans doGet de allCategories");
		JSONArray jsonArray = new JSONArray();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		List<AllCateg> categories = ProductManager.getListCategories();
		for (AllCateg category : categories) {
			JSONObject jsonObject = null;
			try {
				jsonObject = new JSONObject();
				jsonObject.put("text", category.getName());
				jsonObject.put("value", category.getId());
			} catch (JSONException e) {
				e.printStackTrace();
			}
			jsonArray.put(jsonObject);
		}
		response.getWriter().write(jsonArray.toString());
	}
}