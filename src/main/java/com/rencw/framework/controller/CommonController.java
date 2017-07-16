package com.rencw.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UrlPathHelper;

/**  
 * @ClassName: CommonController  
 * @Description: 处理所有以.html或者.htm结尾的请求，这些请求没有找到准确的处理器定义，CommonController处理器会把这些请求映射给InternalResourceViewResolver进行处理
 * @author renchengwei  
 * @date 2017年7月16日  
 *    
 */
@Controller
public class CommonController {
	
	UrlPathHelper pathHelper = new UrlPathHelper();
	@RequestMapping(value={"/**/*.html","/**/*.htm"})
	public String common(HttpServletRequest request,HttpServletResponse response) {
		String url = pathHelper.getLookupPathForRequest(request);
		if(url.startsWith("/")) {
			return url.substring(1, url.lastIndexOf('.'));
		}
		return url;
	}
}
