package com.adobe.poc.core.cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.adobe.poc.core.NetClientGet;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;


public class GuavaCache {

    static LoadingCache<String, String> StringsCache = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterAccess(60, TimeUnit.SECONDS)
            .build(
                    new CacheLoader<String, String>() {
                        public String load(String urlService) {
                               final String String = NetClientGet.callServiceByGet(urlService, NetClientGet.TOKEN);    
                               return String;
                        }
                    }
            );
    
    String getString(String StringId) throws ExecutionException {
        final String String = StringsCache.get(StringId);
        return String; 
    }
    
}