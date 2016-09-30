package com.dcnetworkdisk.common.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class BaseOutput implements Serializable{

	private static final long serialVersionUID = -8857547160019013644L;

	@JsonIgnore
	private Set<RespMsg> errors = new HashSet<RespMsg>();
	
	@JsonIgnore
	private Set<RespMsg> warnings = new HashSet<RespMsg>();
	
	@JsonIgnore
	public boolean isSuccessful(){
		return hasErrors();
	}
	
	public boolean hasErrors(){
		return (errors != null && !errors.isEmpty());
	}
}
