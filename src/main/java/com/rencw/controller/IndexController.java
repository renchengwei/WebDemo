package com.rencw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/left")
	public String left(HttpServletRequest request,HttpServletResponse response) {
		return "left";
	}
	
	@RequestMapping("/footer")
	public String footer(HttpServletRequest request,HttpServletResponse response) {
		return "footer";
	}
	
	@RequestMapping("/top")
	public String top(HttpServletRequest request,HttpServletResponse response) {
		return "top";
	}
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) {
		return "index";
	}
	
}
