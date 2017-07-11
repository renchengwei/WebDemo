package com.rencw;

import java.util.ArrayList;
import java.util.List;

public class Test {

	@org.junit.Test
	public void test() {
		List<String> s = new ArrayList<String>();
		s.add("a");
		s.add("c");
		s.add(1, "b");
		System.out.println(s);
	}
}
