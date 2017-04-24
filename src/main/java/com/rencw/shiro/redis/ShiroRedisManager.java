package com.rencw.shiro.redis;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class ShiroRedisManager {
	
	@Resource
	private RedisTemplate<String, String> template;
	
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
	}
	
	/**
	 * get value from redis
	 * @param key
	 * @return
	 */
	public byte[] get(String key){
		return this.get(key.getBytes());
	}
	
	/**
	 * set 
	 * @param key
	 * @param value
	 * @return
	 */
	public byte[] set(byte[] key,byte[] value){
		return set(key,value,0);
	}
	
	/**
	 * set 
	 * @param key
	 * @param value
	 * @return
	 */
	public byte[] set(String key,byte[] value){
		return this.set(key.getBytes(),value);
	}
	
	
	
	/**
	 * set 
	 * @param key
	 * @param value
	 * @param expire
	 * @return
	 */
	public byte[] set(byte[] key,byte[] value,long expire){
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
	}
	/**
	 * set 
	 * @param key
	 * @param value
	 * @param expire
	 * @return
	 */
	public byte[] set(String key,byte[] value,int expire){
		return this.set(key.getBytes(), value, expire);
	}
	
	/**
	 * del
	 * @param key
	 */
	public long del(byte[] key){
		return template.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.del(key);
			}
		});
	}
	
	public long del(String key) {
		return this.del(key.getBytes());
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
	}
	
	public long incrBy(String key,long value) {
		return template.execute(new RedisCallback<Long>() {
			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				long count = connection.incrBy(key.getBytes(), 1);
				return count;
			}
		});
	}
	
	public boolean expire(String key,long seconds) {
		return template.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.expire(key.getBytes(), seconds);
			}
		});
	}
	
	public boolean setNX(String key,byte[] value,Long seconds) {
		return template.execute(new RedisCallback<Boolean>() {
			@Override
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				boolean ret = connection.setNX(key.getBytes(), value);
				if(seconds != null) {
					connection.expire(key.getBytes(), seconds);
				}
				return ret;
			}
		});
	}
}
