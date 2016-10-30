package com.dcnetworkdisk.common.utils.test;

import org.junit.Test;

import com.dcnetworkdisk.common.utils.EmailUtil;

public class EmailUtilTest{

	@Test
	public void sendEmailTest(){
		String txt = "Someone uses this email address to sign up on the DcNetworkDisk,\r"
				+ "if it wasn't you, please ignore this email.\r"
				+ "if it was you, please click on the following link:\r"
				+ "https://localhost:8080/dcnetworkdisk/u/active?name=huanglong0438&code=8f662b2f3b7d6ac8bd5d3b6799c9bbbe";
		EmailUtil.sendEmail("donglongcheng@foxmail.com", txt);
	}
	
}
