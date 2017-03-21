package com.rencw;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.junit.Test;

import com.rencw.action.TestShiroAction;
import com.rencw.bean.User;
import com.rencw.shiro.redis.RedisCacheManager;

public class TestShiro extends TestSpringBase {

	@Resource
	private TestShiroAction testShiroAction;

	@Resource
	RedisCacheManager RedisCacheManager;
	
	@Test
	public void testShiro() {
		User user = new User("lisi", "123456", "", Boolean.TRUE);
		testShiroAction.login(user);
		testShiroAction.createUser();
		System.out.println(SecurityUtils.getSubject().getPrincipal());
		System.out.println(SecurityUtils.getSubject().getSession().getId());
	}
	@Test
	public void test1() {
		
	}
}
