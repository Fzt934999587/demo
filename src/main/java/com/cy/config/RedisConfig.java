package com.cy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import redis.clients.jedis.Jedis;

public class RedisConfig {

	@Value("${redis.host}")
	private	String host;
	@Value("${redis.port}")
	private Integer port;
	
	/**
	 * 回顾:
	 * 	1.xml配置文件 添加bean标签  (远古时期)
	 *  2.配置类的形式
	 * 配置:
	 * 		将jedis对象交给spring容器管理
	 * 
	 * 利用properties配置文件为属性动态赋值.
	 * 
	 */
	
	@Bean	//<bean id="jedis" Class="">
	public Jedis jedis() {
		
		return new Jedis(host,port);
	}
	
	
}
