package com.cy.controller;


import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.Util.CookieUtils;
import com.cy.Util.JedisUtil;
import com.cy.Util.JsonResult;
import com.cy.Util.ObjectMapperUtil;
import com.cy.Util.OwnRequestUtil;
import com.cy.config.RedisConfig;
import com.cy.pojo.User;
import com.cy.rmodel.RopUserLogin;
import com.cy.service.UserService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;


@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	 @Autowired
	 private HttpServletResponse response;
	 @Autowired
	 private HttpServletRequest request;
	  
	// @Autowired
	// private JedisCluster jedisCluster;
	  
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/doLogin",method = RequestMethod.POST)
	@ResponseBody
	public JsonResult doLogin(@RequestBody RopUserLogin rop) {

		 JsonResult result=userService.login(rop);
		 if(result.getResult()=="1") {
			    User data =(User)result.getData();
			    UUID uuid = UUID.randomUUID(); 
			    
				//将token数据写入Cookie
				Cookie cookie=new Cookie("Token", uuid.toString());
				cookie.setMaxAge(7*24*3600);//cookie的存活时间
				cookie.setPath("/");//cookie的权限
				//cookie.setDomain("jt.com");//实现cookie共享
				response.addCookie(cookie);
				
				JedisUtil.set("Token:"+uuid.toString(), data);

				//jedisCluster.setex(cookie.getName(), 7*24*3600, data.toString());
				//设置没有失效时间的redis
				// redisTemplate.opsForValue().set("Token",data.toString());
		 }

		return result;
		

	}
	
	
	@RequestMapping(value="/doRegister",method = RequestMethod.POST)
	@ResponseBody
	public JsonResult doRegister(@RequestBody User user) {
		user.setCreatedUser(this.getCurrentUserName());
		return userService.register(user);
	}
	
//	@RequestMapping(value="/doRegister",method = RequestMethod.POST)
//	@ResponseBody
//	public JsonResult doUpdate(@RequestBody User user) {
//		user.setCreatedUser(this.getCurrentUserName());
//		return userService.register(user);
//	}
	
	@ResponseBody
	@RequestMapping("/helloworld")
	public String test(){
	        return "helloworld!!!!";
	}
	 
	 
}
