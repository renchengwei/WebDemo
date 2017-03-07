package com.rencw.dao.impl;

import org.springframework.stereotype.Repository;

import com.rencw.dao.TestDao;

@Repository
public class TestDaompl implements TestDao {

	@Override
	public void test() {
		System.out.println("TestDaompl.impl");
	}

}
