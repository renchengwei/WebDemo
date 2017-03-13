package com.rencw;

import javax.annotation.Resource;

import org.junit.Test;

import com.rencw.action.TestShiroAction;
import com.rencw.bean.User;

public class TestShiro extends TestSpringBase {

	@Resource
	private TestShiroAction testShiroAction;
	

	@Test
	public void testShiro() {
		User user = new User("lisi", "123456", "", Boolean.TRUE);
		testShiroAction.login(user);
//		testShiroAction.createUser();
	}
}
