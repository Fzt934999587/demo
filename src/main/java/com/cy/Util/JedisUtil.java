package com.cy.Util;

import redis.clients.jedis.Jedis;

public class JedisUtil {

	public static Jedis getRedis() {
		Jedis jedis = new Jedis("127.0.0.1",6379);
		return jedis;
	}
	
	public static void set(String key,Object val) {
		JedisUtil.getRedis().set(key,ObjectMapperUtil.toJSON(val));
	}
	
	public static String get(String key) {
	  return JedisUtil.getRedis().get(key);
	}
}
