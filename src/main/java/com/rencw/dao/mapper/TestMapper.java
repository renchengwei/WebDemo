package com.rencw.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rencw.bean.TestBean;

@Repository
public interface TestMapper {
	public void insertTest(TestBean test);
	
	public int deleteTest(int id);
	
	public int updateTest(TestBean test);
	
	public List<TestBean> selectTest();
	
	public TestBean selectTestById(int id);
}
