package com.dcnetworkdisk.file.service;

import com.dcnetworkdisk.common.vo.BaseOutput;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UploadFileOutput extends BaseOutput{

	@JsonProperty("fn")
	private String filename;
	
	@JsonProperty("status")
	private boolean isSuccessful;
	
	@JsonProperty("em")
	private String errorMsg;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public boolean isSuccessful() {
		return isSuccessful;
	}

	public void setSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
