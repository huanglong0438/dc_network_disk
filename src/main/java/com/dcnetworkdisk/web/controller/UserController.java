package com.dcnetworkdisk.web.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dcnetworkdisk.common.DcWebResponse;
import com.dcnetworkdisk.common.vo.OutputWrapper;
import com.dcnetworkdisk.user.service.GetSecureTokenInput;
import com.dcnetworkdisk.user.service.GetSecureTokenOutput;
import com.dcnetworkdisk.user.service.LoginInput;
import com.dcnetworkdisk.user.service.LoginOutput;
import com.dcnetworkdisk.user.service.QuotaOutput;
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
	
	@DcWebResponse
	@RequestMapping(value="login", method=RequestMethod.POST)
	public @ResponseBody OutputWrapper<LoginOutput> processLogin(@RequestBody LoginInput input){
		String username = input.getUsername();
		String password = input.getPassword();
		LoginOutput output = userService.ensureUser(username, password);
		OutputWrapper<LoginOutput> wrapper = new OutputWrapper<LoginOutput>();
		wrapper.setResult(output);
		return wrapper;
	}
	
	@DcWebResponse
	@RequestMapping(value="weblogin", method=RequestMethod.POST)
	public @ResponseBody OutputWrapper<LoginOutput> processLogin(HttpServletRequest request, HttpSession session, String username, String password){
		LoginOutput output = userService.ensureUser(username, password);
		
		if(output.getLoginCode() == 200){
			//在session里面写入token
			session.setAttribute("token", output.getToken());
		}
		OutputWrapper<LoginOutput> wrapper = new OutputWrapper<LoginOutput>();
		wrapper.setResult(output);
		return wrapper;
	}
	
	@RequestMapping(value="getUserInfo/{secureToken}", method=RequestMethod.GET)
	public ModelAndView getUserInfo(@PathVariable String secureToken){
		ModelAndView modelAndView = userService.getUserInfo_web(secureToken);
		modelAndView.setViewName("u/userInfo");
		return modelAndView;
	}

	public OutputWrapper<SignUpOutput> signup(@RequestBody SignUpInput input){
		return null;
	}
	
	@RequestMapping(value="quota/{secureToken}", method=RequestMethod.GET)
	public @ResponseBody OutputWrapper<QuotaOutput> quota(@PathVariable String secureToken){
		OutputWrapper<QuotaOutput> wrapper = new OutputWrapper<>();
		wrapper.setResult(userService.getQuota(secureToken));
		return wrapper;
	}
}
