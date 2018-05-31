package com.rencw.framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class CustomExceptionHandler extends SimpleMappingExceptionResolver {

	private static Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		logger.error(ex.toString(), ex);
		return super.resolveException(request, response, handler, ex);
	}
}
