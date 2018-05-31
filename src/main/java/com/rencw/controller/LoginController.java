package com.rencw.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(HttpServletRequest request,HttpServletResponse response) {
        Subject currentUser = SecurityUtils.getSubject();   
        if(currentUser.isAuthenticated()) {
        		return "redirect:index";
        }
		return "login";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="userName") String userName,
			@RequestParam(value="password") String password) {
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);   
        Subject currentUser = SecurityUtils.getSubject();   
        if(!currentUser.isAuthenticated()) {
        		currentUser.login(token);
        }
		return "redirect:index";
	}
}
