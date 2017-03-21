package com.rencw.manager;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisManager {
	
	@Resource
	private RedisTemplate<String, String> template;
	
	// 0 - never expire
	@Value("${shiro_expire_time}")
	private int expire = 0;
	
	/**
	 * get value from redis
	 * @param key
	 * @return
	 */
	public byte[] get(byte[] key){
		return template.execute(new RedisCallback<byte[]>() {
			@Override
			public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.get(key);
			}
		});
//		byte[] value = null;
//		Jedis jedis = jedisPool.getResource();
//		try{
//			value = jedis.get(key);
//		}finally{
//			jedisPool.returnResource(jedis);
//		}
//		return value;
	}
	
	/**
	 * set 
	 * @param key
	 * @param value
	 * @return
	 */
	public byte[] set(byte[] key,byte[] value){
		
		return set(key,value,this.expire);
		
//		Jedis jedis = jedisPool.getResource();
//		try{
//			jedis.set(key,value);
//			if(this.expire != 0){
//				jedis.expire(key, this.expire);
//		 	}
//		}finally{
//			jedisPool.returnResource(jedis);
//		}
//		return value;
	}
	
	/**
	 * set 
	 * @param key
	 * @param value
	 * @param expire
	 * @return
	 */
	public byte[] set(byte[] key,byte[] value,int expire){
		return template.execute(new RedisCallback<byte[]>() {
			@Override
			public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
				connection.set(key,value);
				if(expire != 0) {
					connection.expire(key, expire);
				}
				return value;
			}
		});
//		Jedis jedis = jedisPool.getResource();
//		try{
//			jedis.set(key,value);
//			if(expire != 0){
//				jedis.expire(key, expire);
//		 	}
//		}finally{
//			jedisPool.returnResource(jedis);
//		}
//		return value;
	}
	
	/**
	 * del
	 * @param key
	 */
	public void del(byte[] key){
		template.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				connection.del(key);
				return null;
			}
		});
//		Jedis jedis = jedisPool.getResource();
//		try{
//			jedis.del(key);
//		}finally{
//			jedisPool.returnResource(jedis);
//		}
	}
	
	/**
	 * flush
	 */
	public void flushDB(){
		template.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				connection.flushDb();
				return null;
			}
		});
//		Jedis jedis = jedisPool.getResource();
//		try{
//			jedis.flushDB();
//		}finally{
//			jedisPool.returnResource(jedis);
//		}
	}
	
	/**
	 * size
	 */
	public Long dbSize(){
		return template.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.dbSize();
			}
		});
//		Long dbSize = 0L;
//		Jedis jedis = jedisPool.getResource();
//		try{
//			dbSize = jedis.dbSize();
//		}finally{
//			jedisPool.returnResource(jedis);
//		}
//		return dbSize;
	}

	/**
	 * keys
	 * @param regex
	 * @return
	 */
	public Set<byte[]> keys(String pattern){
		return template.execute(new RedisCallback<Set<byte[]>>() {
			@Override
			public Set<byte[]> doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.keys(pattern.getBytes());
			}
		});
//		
//		Set<byte[]> keys = null;
//		Jedis jedis = jedisPool.getResource();
//		try{
//			keys = jedis.keys(pattern.getBytes());
//		}finally{
//			jedisPool.returnResource(jedis);
//		}
//		return keys;
	}
	

	public int getExpire() {
		return expire;
	}

	public void setExpire(int expire) {
		this.expire = expire;
	}
}
