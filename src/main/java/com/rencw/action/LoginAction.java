package com.rencw.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginAction {
	
//	@Value("${dev_mode}")
//	public boolean devMode = false;
	public String login(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("login");
		return "index";
	}
	
	@RequestMapping("/index.html")
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response,
			ModelAndView modelAndView) {
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	
	@RequestMapping("/createUser")
	@RequiresPermissions("user_create")
	public String createUser(HttpServletRequest request,HttpServletResponse response) {
		return "createuser";
	}
	
	@RequestMapping("/deleteUser")
	@RequiresPermissions("user_aa")
	public String deleteUser(HttpServletRequest request,HttpServletResponse response) {
		return "createuser";
	}
	
	@RequestMapping("/error")
	public String error(HttpServletRequest request,HttpServletResponse response) {
		return "error";
	}
}
