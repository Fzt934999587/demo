package com.cy.service;

import java.util.List;

import com.cy.Util.ResultType;
import com.cy.pojo.User;
import com.cy.rmodel.RopUserLogin;

public interface UserService {

	
	ResultType login(RopUserLogin rop);

	ResultType register(User user);


}
