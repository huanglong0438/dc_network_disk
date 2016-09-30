package com.dcnetworkdisk.user.service;

import com.dcnetworkdisk.common.vo.BaseOutput;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetSecureTokenOutput extends BaseOutput{
	
	private static final long serialVersionUID = -8616515922956331957L;
	@JsonProperty("tk")
	private String secureToken;

	public String getSecureToken() {
		return secureToken;
	}

	public void setSecureToken(String secureToken) {
		this.secureToken = secureToken;
	}
	
}
