package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * 类 @code(HelloworldController)
 *
 * <p>
 *  功能简介：
 * <p>
* springboot简单示例
 * <p>
 *  创建时间：2019年6月20日
 *
 * @author chenxj
 */
@RestController
public class HelloworldController {
	
	private Logger logger = LoggerFactory.getLogger(HelloworldController.class);
		
    @RequestMapping("/test")
    @ResponseBody
    public String forward(){
    	logger.info("受理demo");
    	return "hello.java!";
    }

}
