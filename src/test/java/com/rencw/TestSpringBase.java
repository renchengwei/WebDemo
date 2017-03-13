package com.rencw;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/conf/spring/spring-*.xml" })
public class TestSpringBase extends AbstractJUnit4SpringContextTests {

}
