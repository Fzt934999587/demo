package com.cy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cy.pojo.User;

@Mapper
public interface UserDao {

	

	int findUserInfo(User user);

	
	int userAdd(User user);


	int searchByUserName(String userName);
	
	
}
