package com.rencw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginAction {
	
	@RequestMapping("/doLogin.html")
	public String doLogin(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="userName") String userName,
			@RequestParam(value="password") String password) {
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);   
        Subject currentUser = SecurityUtils.getSubject();   
        if(!currentUser.isAuthenticated()) {
        	currentUser.login(token);
        }
		return "redirect:index.html";
	}
}
