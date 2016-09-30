package com.dcnetworkdisk.user.service;

import com.dcnetworkdisk.common.vo.BaseInput;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value=Include.NON_NULL)
public class LoginInput extends BaseInput{

	private static final long serialVersionUID = -3116623069196584928L;

	@JsonProperty("un")
	private String username;
	
	@JsonProperty("pw")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
