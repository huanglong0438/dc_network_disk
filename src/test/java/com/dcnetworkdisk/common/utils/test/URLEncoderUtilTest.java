package com.dcnetworkdisk.common.utils.test;

import java.io.IOException;

import org.junit.Test;

import com.dcnetworkdisk.common.test.BaseTest;
import com.dcnetworkdisk.common.utils.URLEncoderUtil;

public class URLEncoderUtilTest extends BaseTest{
	
	@Test
	public void encodeTest() throws IOException{
		String url = "/dlc/hahaha";
		url = URLEncoderUtil.encode(url, "utf-8");
		System.out.println(url);
	}
	
}
