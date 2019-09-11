package com.cy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cy.Util.ResultType;
import com.cy.dao.UserDao;
import com.cy.pojo.User;
import com.cy.rmodel.RopUserLogin;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public ResultType login(RopUserLogin rop) {
		
		
		User user=new User();
		user.setUserName(rop.getUserName());
		user.setPassWord(rop.getPassWord());
	    int rows=userDao.findUserInfo(user);
	    //QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
	   // User userDB=userDao.selectOne(queryWrapper);
	    //String token =null;
	    
		if(rows>0)
		{
			return new ResultType("1","1000","登录成功");
			
		}else{
			return new ResultType("2","2000","登录失败");
		}
		
	}


	
	@Override
	public ResultType register(User user) {
		
		int rows=userDao.searchByUserName(user.getUserName());
		if(rows>0) {
			
			return new ResultType("2","2000","用户名已存在");
		}
		
		int r=userDao.userAdd(user);
		if(r>0) {
			return new ResultType("1","1000","注册成功");
		}else {
			return new ResultType("2","2000","注册失败");
		}
		 
	
		
	}
}
