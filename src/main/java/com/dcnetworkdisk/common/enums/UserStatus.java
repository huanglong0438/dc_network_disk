package com.dcnetworkdisk.common.enums;

public enum UserStatus {
	NORMAL(0,"正常"),
	NOT_ACTIVED(1, "未激活");
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private int code;
	
	private String desc;
	
	private UserStatus(int code, String desc){
		this.code = code;
		this.desc = desc;
	}
	
}
