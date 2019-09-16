package com.cy.Util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cy.pojo.User;

public class OwnRequestUtil {

	private HttpServletRequest getRequest() {
		 RequestAttributes ra = RequestContextHolder.getRequestAttributes();
	        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
	        HttpServletRequest request = sra.getRequest();
	return request;
	}
	public String getUserName() {
		
		String token = CookieUtils.getCookieValue(getRequest(), "Token");
		User user=ObjectMapperUtil.toObject(JedisUtil.get("Token:"+token), User.class);
		if(user==null)
			return "";
		return user.getUserName();
	}
	
}
