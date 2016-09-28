package com.dcnetworkdisk.common.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class OutputWrapper<R> implements Serializable {

	@JsonProperty("ec")
	private String errorCode;
	
	@JsonProperty("em")
	private String errorMsg;
	
	@JsonProperty("wc")
	private String warnCode;
	
	@JsonProperty("wm")
	private String warnMsg;
	
	@JsonProperty("rt")
	private R result;
	
	@JsonProperty("sk")
	private String secretKey;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getWarnCode() {
		return warnCode;
	}

	public void setWarnCode(String warnCode) {
		this.warnCode = warnCode;
	}

	public String getWarnMsg() {
		return warnMsg;
	}

	public void setWarnMsg(String warnMsg) {
		this.warnMsg = warnMsg;
	}

	public R getResult() {
		return result;
	}

	public void setResult(R result) {
		this.result = result;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	
}
