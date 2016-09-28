package com.dcnetworkdisk.common.enums;

public enum Order {
	asc("asc","递增"),
	desc("desc","递减");
	
	private String code;
	private String des;
	
	private Order(String code, String des) {
		this.code = code;
		this.des = des;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
	
}
