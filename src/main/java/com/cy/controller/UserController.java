package com.cy.controller;


import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cy.Util.JsonResult;
import com.cy.pojo.User;
import com.cy.rmodel.RopUserLogin;
import com.cy.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	 @Autowired
	 private HttpServletResponse response;
	  @Autowired
	 private HttpServletRequest request;
	  
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/doLogin",method = RequestMethod.POST)
	@ResponseBody
	public JsonResult doLogin(@RequestBody RopUserLogin rop) {

		 JsonResult result=userService.login(rop);
		 if(result.getResult()=="1") {
			
				//将token数据写入Cookie
				Cookie cookie=new Cookie("Token", "fasfaffff");
				cookie.setMaxAge(7*24*3600);//cookie的存活时间
				cookie.setPath("/");//cookie的权限
				//cookie.setDomain("jt.com");//实现cookie共享
				response.addCookie(cookie);
				
		 }

		return result;
		

	}
	
	
	@RequestMapping(value="/doRegister",method = RequestMethod.POST)
	@ResponseBody
	public JsonResult doRegister(@RequestBody User user) {
		return userService.register(user);
	}
	
	
	@ResponseBody
	@RequestMapping("/helloworld")
	public String test(){
	        return "helloworld!!!!";
	}
	 
	 
}
