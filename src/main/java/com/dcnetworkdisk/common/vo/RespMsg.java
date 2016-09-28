package com.dcnetworkdisk.common.vo;

import java.io.Serializable;

public class RespMsg implements Serializable{
	
	private String code;
	private String message;
	private String[] params;
	
	

	public RespMsg(String code, String message) {
		this(code, message, (String[])null);
	}



	public RespMsg(String code, String message, String... params) {
		this.code = code;
		this.message = message;
		this.params = params;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}
	
	public String[] getParams() {
		return params;
	}
	
	
}
