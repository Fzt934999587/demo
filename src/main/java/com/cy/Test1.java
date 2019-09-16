package com.cy;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class Test1 {

	@Test
	public void test01(){
		Jedis jedis = new Jedis("127.0.0.1",6379);
		jedis.set("redis", "redis入门案例");
		System.out.println
		("获取redis中的数据:"+jedis.get("redis"));
		//为数据设定超时时间  单位秒
		jedis.setex("1804", 100, "1804班");
	}
}
