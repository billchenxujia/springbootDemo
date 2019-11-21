package com.example.demo.service.comm.imp;

import org.springframework.stereotype.Service;

import com.example.demo.service.comm.CommonXStreamService;
import com.thoughtworks.xstream.XStream;

/**
 * 
 * 类 @code(DefaultXStreamServiceImp)
 *
 * <p>
 * 功能简介：
 * <p>
 * 默认获取XStream对象实现
 * <p>
 * 创建时间：2019年9月9日
 *
 * @author chenxj
 */
@Service("commonXStreamService")
public class DefaultXStreamServiceImp implements CommonXStreamService {

	/**
	 * 通过传入的自定义的业务详情对象，返回相应的 {@code XStream}。注：默认业务对象只有一个
	 * 
	 * @param clazz 自定义业务类对象
	 * @return XStream对象
	 */
	@Override
	public XStream getXStream(Class<?> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 通过传入的自定义的业务详情对象，返回相应的 {@code XStream}。
	 * 
	 * @param clazz 自定义业务类对象
	 * @param count 一个报文里业务对象的个数
	 * @return XStream对象
	 */
	@Override
	public XStream getXStream(Class<?> clazz, int count) {
		// TODO Auto-generated method stub
		return null;
	}

}
