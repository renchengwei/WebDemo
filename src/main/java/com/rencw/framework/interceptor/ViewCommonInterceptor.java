package com.rencw.framework.interceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ViewCommonInterceptor implements HandlerInterceptor,ServletContextAware{

	private Logger log = Logger.getLogger(ViewCommonInterceptor.class);
	
	@Value("${dev_mode}")
	private boolean devMode;
	@Value("${app_server_host}")
	private String appServerHost = "127.0.0.1";
	@Value("${app_server_port}")
	private String appServerPort = "80";
	@Value("${app_server_path}")
	private String appServerPath = "/";
	@Value("${static_server_host}")
	private String staticServerHost = "127.0.0.1";
	@Value("${static_server_port}")
	private String staticServerPort = "80";
	@Value("${static_server_path}")
	private String staticServerPath = "/";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//控制浏览器缓存
		log.debug("devMode:" + devMode);
		log.debug("appServerHost:" + appServerHost);
		log.debug("appServerPort:" + appServerPort);
		log.debug("appServerPath:" + appServerPath);
		log.debug("staticServerHost:" + staticServerHost);
		log.debug("staticServerPort:" + staticServerPort);
		log.debug("staticServerPath:" + staticServerPath);
		
		if(devMode) {
			response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1  
			response.addHeader("Cache-Control", "no-store"); //Firefox  
			response.setHeader("Pragma", "no-cache"); //HTTP 1.0  
			response.setDateHeader("Expires", -1);  
			response.setDateHeader("max-age", 0); 
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		// 设置页面公用参数
		servletContext.setAttribute("appServerHost", appServerHost);
		servletContext.setAttribute("appServerPort", appServerPort);
		servletContext.setAttribute("appServerPath", appServerPath);
		servletContext.setAttribute("staticServerHost", staticServerHost);
		servletContext.setAttribute("staticServerPort", staticServerPort);
		servletContext.setAttribute("staticServerPath", staticServerPath);
		servletContext.setAttribute("appServer", "http://" + appServerHost + ":" + appServerPort + "/" + appServerPath);
		servletContext.setAttribute("staticServer", "http://" + staticServerHost + ":" + staticServerPort + "/" + staticServerPath);
	}

}
