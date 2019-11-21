package com.example.demo.service.comm;

import com.thoughtworks.xstream.XStream;

/**
 * 
 * 类 @code(CommonSeltXmlParseService)
 *
 * <p>
 *  功能简介：
 * <p>
* 清算协会xml,javaBean报文解析转换顶级接口
 * <p>
 *  创建时间：2019年9月7日
 *
 * @author chenxj
 */
public interface CommonXStreamService {
	
	/**
	 * 通过传入的自定义的业务详情对象，返回相应的
	 * {@code XStream}。注：默认业务对象只有一个
	 * @param clazz 自定义业务类对象
	 * @return XStream对象
	 */
	XStream getXStream(Class<?> clazz);
	
	/**
	 * 通过传入的自定义的业务详情对象，返回相应的
	 * {@code XStream}。
	 * @param clazz 自定义业务类对象
	 * @param count 一个报文里业务对象的个数
	 * @return XStream对象
	 */
	XStream getXStream(Class<?> clazz,int count);
}
