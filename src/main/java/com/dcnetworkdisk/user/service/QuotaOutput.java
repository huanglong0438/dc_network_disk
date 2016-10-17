package com.dcnetworkdisk.user.service;

import java.math.BigDecimal;

import com.dcnetworkdisk.common.vo.BaseOutput;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value=JsonInclude.Include.NON_NULL)
public class QuotaOutput extends BaseOutput{

	private static final long serialVersionUID = -2672138526300210483L;

	private BigDecimal quota;
	
	private BigDecimal used;
	
	public BigDecimal getQuota() {
		return quota;
	}

	public void setQuota(BigDecimal quota) {
		this.quota = quota;
	}

	public BigDecimal getUsed() {
		return used;
	}

	public void setUsed(BigDecimal used) {
		this.used = used;
	}

}
