package com.dcnetworkdisk.common.enums;

public enum OrderBy {
	TIME("modified_date", "时间"),
	NAME("filename", "名字"),
	SIZE("filesize", "大小");
	
	private String code;
	private String desc;
	
	private OrderBy(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
