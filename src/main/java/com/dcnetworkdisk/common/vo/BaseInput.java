package com.dcnetworkdisk.common.vo;

import java.io.Serializable;

import com.dcnetworkdisk.common.model.UserContext;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class BaseInput implements Serializable{
	
	private static final long serialVersionUID = -3373240258947885163L;
	@JsonIgnore
	private UserContext userContext = new UserContext();
	
	public UserContext getUserContext() {
		return userContext;
	}
	
	public void setUserContext(UserContext userContext) {
		this.userContext = userContext;
	}
}
