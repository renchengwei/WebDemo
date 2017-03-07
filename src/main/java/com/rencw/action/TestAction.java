package com.rencw.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.rencw.service.TestService;

@Controller
public class TestAction {

	@Resource
	private TestService testService;
	
	public void test() {
		System.out.println("TestAction.test");
		testService.test();
	}
}
