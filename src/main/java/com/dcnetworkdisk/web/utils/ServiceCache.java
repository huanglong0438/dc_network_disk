package com.dcnetworkdisk.web.utils;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.dcnetworkdisk.core.utils.RedisCacheUtils;

@Component
public class ServiceCache {

	private RedisCacheUtils cacheUtils = null;
	
	public static final int HALF_HOUR = 1800;
	
	@PostConstruct
	private void init(){
		String url = "localhost";
		int port = 6379;
		cacheUtils = new RedisCacheUtils(url, port);
	}

	public String get(String key){
		return cacheUtils.get(key);
	}
	
	public String put(String key, String value, int seconds){
		return cacheUtils.put(key, value, seconds);
	}
	
	public String getRefresh(String key, int seconds){
		return cacheUtils.getRefresh(key, seconds);
	}
}
