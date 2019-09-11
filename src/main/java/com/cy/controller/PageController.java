package com.cy.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cy.Util.CookieUtils;

@Controller
public class PageController {
	
	@RequestMapping("/login")
	public String login(){
			return "doLogin";
	}
	
	@RequestMapping("/home")
	public String home(HttpServletResponse response,HttpServletRequest request){
		
		if(CookieUtils.getCookieValue(request, "token")==null) {
			return "redirect:/login";
		}
		
		// 没有就跳转到 登录页面
		
		// 有继续 home
		return "home";
	}
}
