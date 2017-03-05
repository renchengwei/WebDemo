package com.rencw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/conf/spring/spring-*.xml" })
public class TestSpring  extends AbstractJUnit4SpringContextTests{

	@Test
	public void test1() {
		System.out.println("ok");
	}
	
	public void test2() {
	}
	@Test
	public void saveUser() {
	}
}
