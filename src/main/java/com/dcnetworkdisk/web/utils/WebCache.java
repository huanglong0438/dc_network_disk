package com.dcnetworkdisk.web.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WebCache {
	
	private static final String SECURE_TOKEN = "sc_";
	
	private static final String USER_CONTEXT = "_uc";
	
	@Autowired
	private ServiceCache serviceCache;
	
	private static int HALF_HOUR = ServiceCache.HALF_HOUR;

	public String getSecureToken(String username){
		return serviceCache.get(SECURE_TOKEN + username);
	}
	
	public void setSecureToken(String username, String secureToken){
		serviceCache.put(SECURE_TOKEN + username, secureToken, HALF_HOUR);
	}
	
	public void setUserContext(String secureToken, String username){
		serviceCache.put(secureToken + USER_CONTEXT, username, HALF_HOUR);
	}
	
	public String getUsername(String secureToken){
		return serviceCache.getRefresh(secureToken + USER_CONTEXT, HALF_HOUR);
	}
}
