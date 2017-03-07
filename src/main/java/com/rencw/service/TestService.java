package com.rencw.service;

import java.util.List;

import com.rencw.bean.TestBean;

public interface TestService {
	public void test();
	public void insertTest(TestBean test);
	public int deleteTest(int id);
	public int updateTest(TestBean test);
	public List<TestBean> selectTest();
	public TestBean selectTestById(int id);
}
