package com.rencw;

import java.util.ArrayList;
import java.util.List;

public class Test {

	@org.junit.Test
	public void test() {
		String a = "/test.html";
		System.out.println(a.substring(1, a.lastIndexOf('.')));
	}
}
