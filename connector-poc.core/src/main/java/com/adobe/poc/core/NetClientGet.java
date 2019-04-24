package com.adobe.poc.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class NetClientGet {

	private static final Logger LOGGER = LoggerFactory.getLogger(NetClientGet.class);

	public static final String TOKEN = "z8rezsyfrx6ku21syxpyxlceoxmwjq1u";
	
	public static LoadingCache<String, String> cache = CacheBuilder.newBuilder()
			  .maximumSize(1000)
			  .expireAfterAccess(60, TimeUnit.SECONDS)
			  .recordStats()
			  .build(new CacheLoader<String, String>() {
                  public String load(String urlService) {
                      final String String = NetClientGet.callServiceByGet(urlService, NetClientGet.TOKEN);    
                      return String;
               }
			  });

	public static String callServiceByGetCached(String urlService, String token) {
		String result = null;
		try {
			result = cache.get(urlService);
		} catch (ExecutionException e) {
			LOGGER.error("Error while call service rest from cache", e);
		}
		return result;
	}
	
	public static String callServiceByGet(String urlService, String token) {
		String output = "";
		try {
			// String token = getAdminCredential();
			URL url = new URL(urlService);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (StringUtils.isNotBlank(token)) {
				conn.setRequestProperty("Authorization", "Bearer " + token);
			}

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String line = null;
			while ((line = br.readLine()) != null) {
				output += line;
			}

			conn.disconnect();

		} catch (IOException e) {
			LOGGER.error("Error while callServiceByGet", e);
		}
		return output;
	}

	public static String callServiceByPost(String urlService, final String POST_PARAMS) {
		String output = null;
		URL obj;
		try {
			obj = new URL(urlService);

			HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
			postConnection.setRequestMethod("POST");
			postConnection.setRequestProperty("Content-Type", "application/json");
			postConnection.setDoOutput(true);
			OutputStream os = postConnection.getOutputStream();
			os.write(POST_PARAMS.getBytes());
			os.flush();
			os.close();
			int responseCode = postConnection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				// print result
				output = response.toString();
			} else {
				LOGGER.error("POST NOT WORKED");
			}
		} catch (IOException e) {
			LOGGER.error("Error while callServiceByPost", e);
		}
		return output;
	}

}