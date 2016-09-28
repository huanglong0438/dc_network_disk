package com.dcnetworkdisk.file.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_file_list")
public class DcFile {
	@Id
	@GeneratedValue
	private int fid;
	private String filename;
	private String filetype;
	private String isdir;
	private String filepath;
	private BigDecimal filesize;
	private Date create_date;
	private Date modified_date;
	private String ownerName;
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public BigDecimal getFilesize() {
		return filesize;
	}
	public void setFilesize(BigDecimal filesize) {
		this.filesize = filesize;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getModified_date() {
		return modified_date;
	}
	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getIsdir() {
		return isdir;
	}
	public void setIsdir(String isdir) {
		this.isdir = isdir;
	}
	
}
