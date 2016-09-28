package com.dcnetworkdisk.web.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WebCache {
	
	private static final String SECURE_TOKEN = "sc_";
	
	@Autowired
	private ServiceCache serviceCache;
	
	private static int HALF_HOUR = ServiceCache.HALF_HOUR;

	public String getSecureToken(String username){
		return serviceCache.get(SECURE_TOKEN + username);
	}
	
	public void setSecureToken(String username, String secureToken){
		serviceCache.put(secureToken, username, HALF_HOUR);
	}
	
	public String getUsername(String secureToken){
		return serviceCache.get(secureToken);
	}
}
