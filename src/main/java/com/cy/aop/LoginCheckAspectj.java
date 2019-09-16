package com.cy.aop;

import com.cy.Util.CookieUtils;
import com.cy.Util.JedisUtil;
import com.cy.Util.ObjectMapperUtil;

import lombok.extern.log4j.Log4j;
import redis.clients.jedis.Jedis;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * 登录检查，检查通过后，将在TreadLocal中放入从数据库中取出的User对象
 */
@Aspect
@Order(2)
@Component
public class LoginCheckAspectj {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginCheckAspectj.class);
 

    /**
     * 1.获取request信息
     * 2.根据request 的header获得用户登录凭证信息token
     * 3.解析token取出登录用户信息
     */
    @Around(value = "@annotation(com.cy.anno.LoginCheck)")
    public Object check(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        try {
        	
        	String loginUrl="redirect:/login";
        	String token = CookieUtils.getCookieValue(request, "Token");//
        	if(token==null) {
    			return loginUrl;
    		}
        	
			Object tokenVal = JedisUtil.get("Token:"+token);
			if(tokenVal==null) {
				return loginUrl;
			}
			
        } catch(Throwable e) {
        	LOGGER.error(e.getMessage());
        	throw new RuntimeException(e);
        }
        
        return pjp.proceed();
    }
}
