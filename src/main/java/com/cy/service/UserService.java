package com.cy.service;

import java.util.List;

import com.cy.Util.JsonResult;
import com.cy.pojo.User;
import com.cy.rmodel.RopUserLogin;

public interface UserService {

	
	JsonResult login(RopUserLogin rop);

	JsonResult register(User user);


}
