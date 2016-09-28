package com.dcnetworkdisk.user.service;

import com.dcnetworkdisk.common.vo.BaseOutput;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetSecureTokenOutput extends BaseOutput{
	
	@JsonProperty("tk")
	private String secureToken;

	public String getSecureToken() {
		return secureToken;
	}

	public void setSecureToken(String secureToken) {
		this.secureToken = secureToken;
	}
	
}
