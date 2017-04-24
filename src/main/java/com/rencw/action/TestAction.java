package com.rencw.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.rencw.service.TestService;
  
  
/**  
 * @ClassName: TestAction  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author renchengwei  
 * @date 2017年4月3日  
 *    
 */
@Controller
public class TestAction {

	@Resource
	private TestService testService;
	
	public void test() {
		System.out.println("TestAction.test");
		testService.test();
	}
}
