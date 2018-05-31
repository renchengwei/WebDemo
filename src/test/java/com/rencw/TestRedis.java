package com.rencw;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class TestRedis extends TestSpringBase {

	@Resource
	private RedisTemplate<String, String> redisTemplate;
	@Test
	public void test1() {
		ValueOperations<String, String> oper = redisTemplate.opsForValue();
		oper.set("rencw1", "任成威");
		System.out.println(oper.get("rencw1"));
//		redisTemplate.execute(new RedisCallback<Object>() {
//			@Override
//			public Object doInRedis(RedisConnection connection) throws DataAccessException {
//				connection.set("abc".getBytes(), "456".getBytes());
//				return null;
//			}
//		});
	}
	
	@Test
	public void test2() {
		
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				connection.del("shiro_redis_cache:lisi".getBytes());
				return null;
			}
		});
	}
	@Test
	public void test3() {
		
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				connection.set("aa".getBytes(), "bb".getBytes());
				System.out.println(new String(connection.get("aa".getBytes())));
				return null;
			}
		});
	}
	
	
}
