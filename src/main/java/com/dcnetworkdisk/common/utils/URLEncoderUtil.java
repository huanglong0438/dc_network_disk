package com.dcnetworkdisk.common.utils;

import java.io.IOException;
import java.net.URLEncoder;


public class URLEncoderUtil {
	public static String encode(String url, String enc) throws IOException{
		url = url.replace("/", "%2f");
		url = URLEncoder.encode(url, "utf-8");
		return url;
	}

}
