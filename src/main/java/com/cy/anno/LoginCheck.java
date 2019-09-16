package com.cy.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 登录检查注解
 *
 */
@Target(ElementType.METHOD)//注解使用范围
@Retention(RetentionPolicy.RUNTIME)//注解运行时机
public @interface LoginCheck {

}
