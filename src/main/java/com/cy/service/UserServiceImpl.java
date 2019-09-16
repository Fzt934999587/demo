package com.cy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.Util.JsonResult;
import com.cy.dao.UserDao;
import com.cy.pojo.User;
import com.cy.rmodel.RopUserLogin;

import redis.clients.jedis.JedisCluster;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	
	
	@Override
	public JsonResult login(RopUserLogin rop) {
		
		
		User user=new User();
		user.setUserName(rop.getUserName());
		user.setPassWord(rop.getPassWord());
	    User userDB=userDao.findUserInfo(user);
		if(userDB!=null)
		{
			return new JsonResult("1","1000","登录成功",userDB);
		}else {
			return  new JsonResult("2","2000","登录失败");
			}
		
		
	}


	
	@Override
	public JsonResult register(User user) {
		
		int rows=userDao.searchByUserName(user.getUserName());
		if(rows>0) {
			
			return new JsonResult("2","2000","用户名已存在");
		}
		
		int r=userDao.userAdd(user);
		if(r>0) {
			return new JsonResult("1","1000","注册成功");
		}else {
			return new JsonResult("2","2000","注册失败");
		}
		 
	
		
	}
}
