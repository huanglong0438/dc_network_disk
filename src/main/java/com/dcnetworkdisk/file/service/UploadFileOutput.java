package com.dcnetworkdisk.file.service;

import java.math.BigDecimal;
import java.util.Date;

import com.dcnetworkdisk.common.vo.BaseOutput;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UploadFileOutput extends BaseOutput{
	
	private static final long serialVersionUID = -2880032531486337718L;

	@JsonProperty("fid")
	private int fid;
	
	@JsonProperty("fn")
	private String filename;
	
	@JsonProperty("path")
	private String path;
	
	@JsonProperty("size")
	private BigDecimal size;
	
	@JsonProperty("ctime")
	private Date create_time;
	
	@JsonProperty("mtime")
	private Date modified_time;
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public BigDecimal getSize() {
		return size;
	}

	public void setSize(BigDecimal size) {
		this.size = size;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getModified_time() {
		return modified_time;
	}

	public void setModified_time(Date modified_time) {
		this.modified_time = modified_time;
	}
}
