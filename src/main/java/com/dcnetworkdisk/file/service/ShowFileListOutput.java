package com.dcnetworkdisk.file.service;

import java.util.List;

import com.dcnetworkdisk.common.vo.BaseOutput;
import com.dcnetworkdisk.file.model.DcFile;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ShowFileListOutput extends BaseOutput{
	
	private static final long serialVersionUID = -1099872830531165728L;
	@JsonProperty("fl")
	private List<DcFile> filelist;

	public List<DcFile> getFilelist() {
		return filelist;
	}

	public void setFilelist(List<DcFile> filelist) {
		this.filelist = filelist;
	}
	
}
