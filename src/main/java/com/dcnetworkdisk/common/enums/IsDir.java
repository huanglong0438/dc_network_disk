package com.dcnetworkdisk.common.enums;

public enum IsDir {
	file("0", "文件"),
	dir("1", "目录");
	
	private String code;
	
	private String desc;
	
	private IsDir(String code, String desc) {
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
