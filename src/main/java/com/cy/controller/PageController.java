package com.cy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.Util.CookieUtils;
import com.cy.aop.LoginCheck;

@Controller
public class PageController {
	
	 @Autowired
	 private HttpServletResponse response;
	  @Autowired
	 private HttpServletRequest request;
	  
	@RequestMapping("/login")
	public String login(){
			return "login";
	}
	
	@RequestMapping("/home")
	@LoginCheck
	public String home(){
		
//		if(CookieUtils.getCookieValue(request, "Token")==null) {
//			return "redirect:/login";
//		}
		
		// 没有就跳转到 登录页面
		
		
			return "home";
	}
	
	@LoginCheck
	@RequestMapping("/index")
	public String index(){
//		if(CookieUtils.getCookieValue(request, "Token")==null) {
//			return "redirect:/login";
//		}
		
			return "index";
	}
}
