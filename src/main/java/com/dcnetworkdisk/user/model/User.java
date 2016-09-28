package com.dcnetworkdisk.user.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user")
public class User{
	@Id
	@GeneratedValue
	private int uid;
	private String username;
	private String password;
	private String avatar;
	private String whatsup;

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
