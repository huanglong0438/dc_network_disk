package com.dcnetworkdisk.common.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserOutput implements Serializable{

	private static final long serialVersionUID = -6201525166833190046L;

	@JsonProperty("uid")
	private int uid;

	@JsonProperty("un")
	private String username;

	@JsonProperty("pw")
	private String password;

	@JsonProperty("av")
	private String avatar;

	@JsonProperty("wu")
	private String whatsup;

	public UserOutput(int uid, String username, String password, String avatar,
			String whatsup) {
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.avatar = avatar;
		this.whatsup = whatsup;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getWhatsup() {
		return whatsup;
	}

	public void setWhatsup(String whatsup) {
		this.whatsup = whatsup;
	}
	
	
	
}
