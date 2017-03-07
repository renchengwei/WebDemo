package com.rencw.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rencw.bean.TestBean;
import com.rencw.dao.TestDao;
import com.rencw.mapper.TestMapper;
import com.rencw.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Resource
	private TestDao testDao;
	@Resource
	private TestMapper testMapper;
	
	@Override
	public void test() {
		System.out.println("TestServiceImpl.test");
		testDao.test();
	}
	@Override
	@Transactional
	public void insertTest(TestBean test) {
		testMapper.insertTest(test);
		System.out.println(test.getId());
	}
	@Override
	@Transactional
	public int deleteTest(int id) {
		return testMapper.deleteTest(id);
	}
	@Override
	@Transactional
	public int updateTest(TestBean test) {
		return testMapper.updateTest(test);
	}
	@Override
	public List<TestBean> selectTest() {
		return testMapper.selectTest();
	}
	@Override
	public TestBean selectTestById(int id) {
		return testMapper.selectTestById(id);
	}
}
