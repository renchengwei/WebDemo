package com.rencw;

import java.io.FileNotFoundException;
import java.net.URL;

import org.junit.runners.model.InitializationError;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ResourceUtils;
import org.springframework.util.SystemPropertyUtils;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

public class JUnit4ClassRunner extends SpringJUnit4ClassRunner {
	static {  
		
		LoggerContext lc = (LoggerContext)LoggerFactory.getILoggerFactory();  
        JoranConfigurator configurator = new JoranConfigurator();  
        configurator.setContext(lc);  
        lc.reset();  

        try {
        		String resolvedLocation = SystemPropertyUtils.resolvePlaceholders("classpath:conf/logback.xml");
        		URL url = ResourceUtils.getURL(resolvedLocation);
			configurator.doConfigure(url);
		} catch (JoranException | FileNotFoundException e) {
			e.printStackTrace();
		}
    }  
      
    public JUnit4ClassRunner(Class<?> clazz) throws InitializationError {  
        super(clazz);  
    }
}
