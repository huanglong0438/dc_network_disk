package com.dcnetworkdisk.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcnetworkdisk.common.vo.OutputWrapper;
import com.dcnetworkdisk.common.vo.UserOutput;
import com.dcnetworkdisk.user.service.UserService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("hello")
	public String helloWorld(){
		return "hello dc netdisk.";
	}
	
	@RequestMapping(value="/getUserInfo/{uid}")
	public OutputWrapper<UserOutput> getUserInfo(@PathVariable int uid){
		return userService.getUserInfo(uid);
	}
	
}
