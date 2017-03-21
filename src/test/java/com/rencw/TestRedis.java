package com.rencw;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

public class TestRedis extends TestSpringBase {

	@Resource
	private RedisTemplate<String, String> redisTemplate;
	
	@Test
	public void test1() {
		
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				connection.set("abc".getBytes(), "456".getBytes());
				return null;
			}
		});
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
	
	
}
