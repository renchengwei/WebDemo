package com.rencw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import org.springframework.util.ResourceUtils;
import org.springframework.util.SystemPropertyUtils;

public class Test {
	public static void main(String[] args) throws FileNotFoundException {
//		File file = new File("./conf/logback.xml");
//		String path = Test.class.getResource("/").toString();
//        URL classPath = Thread.currentThread().getContextClassLoader().getResource("");  
//        InputStream in = Test.class.getResourceAsStream("/com/lavasoft/res/a.txt"); 
//		System.out.println(classPath);
		
		String resolvedLocation = SystemPropertyUtils.resolvePlaceholders("classpath:conf/log4j.properties");
		URL url = ResourceUtils.getURL(resolvedLocation);
//		if (ResourceUtils.URL_PROTOCOL_FILE.equals(url.getProtocol()) && !ResourceUtils.getFile(url).exists()) {
//			throw new FileNotFoundException("Log4j config file [" + resolvedLocation + "] not found");
//		}
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
	}
}
