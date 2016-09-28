package com.dcnetworkdisk.web.controller;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dcnetworkdisk.common.vo.OutputWrapper;
import com.dcnetworkdisk.user.service.GetSecureTokenInput;
import com.dcnetworkdisk.user.service.GetSecureTokenOutput;
import com.dcnetworkdisk.user.service.LoginInput;
import com.dcnetworkdisk.user.service.LoginOutput;
import com.dcnetworkdisk.user.service.SignUpInput;
import com.dcnetworkdisk.user.service.SignUpOutput;
import com.dcnetworkdisk.user.service.UserService;

@Controller
@RequestMapping("/u")
public class UserController {

	@Autowired
	private UserService userService;
	
	public OutputWrapper<GetSecureTokenOutput> getSecureToken(@RequestBody GetSecureTokenInput input){
		return null;
	} 
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void login(){
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public @ResponseBody OutputWrapper<LoginOutput> processLogin(@RequestBody LoginInput input){
		String username = input.getUsername();
		String password = input.getPassword();
		LoginOutput output = userService.ensureUser(username, password);
		OutputWrapper<LoginOutput> wrapper = new OutputWrapper<LoginOutput>();
		wrapper.setResult(output);
		return wrapper;
	}
	
	@RequestMapping(value="weblogin", method=RequestMethod.POST)
	public @ResponseBody OutputWrapper<LoginOutput> processLogin(String username, String password){
		LoginOutput output = userService.ensureUser(username, password);
		OutputWrapper<LoginOutput> wrapper = new OutputWrapper<LoginOutput>();
		wrapper.setResult(output);
		return wrapper;
	}
	

	public String login2(@RequestBody LoginInput input){
		String username = input.getUsername();
		String password = input.getPassword();
		String token = "afsdfldsjflsfuewior";
		return token;
	}

	public OutputWrapper<SignUpOutput> signup(@RequestBody SignUpInput input){
		return null;
	}
}
