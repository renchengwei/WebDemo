package com.rencw.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginAction {
	public String login(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("login");
		return "index";
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
