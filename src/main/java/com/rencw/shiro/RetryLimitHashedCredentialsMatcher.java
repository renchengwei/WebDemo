package com.rencw.shiro;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

import com.rencw.manager.RedisManager;

public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

	@Resource
	private RedisManager redisManager;
	
	/**
	 * 默认重复登录次数
	 */
	private long retryCount = 5;
	
	/**
	 * 默认重复登录时间
	 */
	private long retryTime = 3600;
	
	/**
	 * 默认锁定时间
	 */
	private long lockTime = 10800;
	
	public long getLockTime() {
		return lockTime;
	}

	public void setLockTime(long lockTime) {
		this.lockTime = lockTime;
	}

	public long getRetryTime() {
		return retryTime;
	}

	public void setRetryTime(long retryTime) {
		this.retryTime = retryTime;
	}

	public long getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(long retryCount) {
		this.retryCount = retryCount;
	}

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		String username = (String)token.getPrincipal();
		String key = "password-retry-cache:" + username;
		//计数器计算重复登录次数
		long count = redisManager.incrBy(key, 1);
		if(count == 1) {
			redisManager.expire(key, retryTime);
		}
		
		//如果是初次登录，设置超时时间
		if(count > retryCount) {
            throw new ExcessiveAttemptsException();  
        } 
        boolean matches = super.doCredentialsMatch(token, info);  
        //登录成功后清除计数器
        if(matches) {  
        	redisManager.del(key);
        } else if(count == retryCount) {//没有成功并且最后一次尝试
        	redisManager.expire(key, lockTime);
		}
		return matches;
	}
}
