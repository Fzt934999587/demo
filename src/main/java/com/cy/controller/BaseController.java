package com.cy.controller;

import org.springframework.stereotype.Controller;

import com.cy.Util.OwnRequestUtil;


public class BaseController {

	public BaseController() {
		
	}
	
	public String getCurrentUserName() {
		String createdUser = new OwnRequestUtil().getUserName();
		return  createdUser;
		
		
	}
}
