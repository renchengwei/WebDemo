package com.rencw;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.SerializationUtils;

import com.rencw.bean.User;

import redis.clients.jedis.Jedis;

public class TestRedis {

	private Jedis jedis;
	@Resource
	private RedisTemplate tedisTemplate;
	
//	@Before
//	public void before() {
//		jedis = new Jedis("192.168.78.104",6379);
//		jedis.auth("rencw@123");
//		
//	}
	
	@Test
	public void test() {
		jedis.set("rencw", "renchengwei");
		System.out.println(jedis.get("rencw"));
		
		List<String> list = new ArrayList();
		list.add("abc");
		list.add("123");
		jedis.set("message".getBytes(), SerializationUtils.serialize(list));
		
		Object obj = SerializationUtils.deserialize(jedis.get("message".getBytes()));
		System.out.println(obj);
		
		
		User user = new User();
		user.setGmtCreate(new Date());
		user.setUserName("zhangsan");
		jedis.set("zhangsan".getBytes(),SerializationUtils.serialize(user) );
	}
	
	public void test1() {
	}
	
//	@After
//	public void after() {
//		jedis.close();
//	}
}
