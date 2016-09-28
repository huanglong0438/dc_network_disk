package com.dcnetworkdisk.user.service;

import com.dcnetworkdisk.common.vo.BaseOutput;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = Include.NON_NULL)
public class LoginOutput extends BaseOutput{

	//200--ok, 300--密码错误， 400--用户不存在
	@JsonProperty("lc")
	private int loginCode;

	@JsonProperty("lm")
	private String loginMsg;
	
	@JsonProperty("tk")
	private String token;
	
	public int getLoginCode() {
		return loginCode;
	}

	public void setLoginCode(int loginCode) {
		this.loginCode = loginCode;
	}

	public String getLoginMsg() {
		return loginMsg;
	}

	public void setLoginMsg(String loginMsg) {
		this.loginMsg = loginMsg;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
