package com.cy.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cy.Util.ResultType;
import com.cy.pojo.User;
import com.cy.rmodel.RopUserLogin;
import com.cy.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/doLogin",method = RequestMethod.POST)
	@ResponseBody
	public ResultType doLogin(@RequestBody RopUserLogin rop) {

		///sss
		
		//dd
		//da
		//dasd 4,56
		return userService.login(rop);
		

	}
	
	
	@RequestMapping(value="/doRegister",method = RequestMethod.POST)
	@ResponseBody
	public ResultType doRegister(@RequestBody User user) {
		return userService.register(user);
	}
	
	
	@ResponseBody
	@RequestMapping("/helloworld")
	public String test(){
	        return "helloworld!!!!";
	}
	 
	 
}
