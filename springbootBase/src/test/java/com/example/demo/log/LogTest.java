package com.example.demo.log;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * 类 @code(LogTest)
 *
 * <p>
 *  功能简介：
 * <p>
* springboot日志测试
 * <p>
 *  创建时间：2019年8月25日
 *
 * @author chenxj
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class LogTest {
	
	private Logger logger = LoggerFactory.getLogger(Logger.class);
	
	@Test
	public void loadContext() {
		logger.trace("trace级别日志");
		logger.debug("debug级别日志");
		logger.info("info级别日志");
		logger.warn("warn级别日志");
		logger.error("error级别日志");
	}
}
