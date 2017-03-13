package com.rencw;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.rencw.action.TestAction;
import com.rencw.bean.TestBean;
import com.rencw.service.TestService;

public class TestSpring  extends TestSpringBase {

	@Resource
	private TestAction testAction;
	@Resource
	private TestService testService;
	
	@Test
	public void test1() {
		testAction.test();
	}
	@Test
	public void test2() {
		TestBean test = new TestBean();
		test.setName("aa");
		test.setGmtCreate(new Date());
		test.setMemo("ok");
		testService.insertTest(test);
	}
	@Test
	public void test3() {
		System.out.println(testService.deleteTest(2));
	}
	@Test
	public void test4() {
		TestBean test = new TestBean();
		test.setId(3);
		test.setMemo("this is update result");
		System.out.println(testService.updateTest(test));
	}
	
	@Test
	public void test5() {
		TestBean bean = testService.selectTestById(1);
		System.out.println(bean.getGmtCreate());
	}
	@Test
	public void test6() {
		List<TestBean> list = testService.selectTest();
	}
	
	
}
