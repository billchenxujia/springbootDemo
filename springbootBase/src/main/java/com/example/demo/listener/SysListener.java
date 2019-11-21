package com.example.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class SysListener implements ServletContextListener{
	private Logger logger = LoggerFactory.getLogger(SysListener.class);
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.info("------demoServlet开始启动--------");
	}
 
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		logger.info("------demoServlet开始销毁--------");
		
	}

}
