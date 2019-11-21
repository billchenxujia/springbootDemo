package com.example.demo.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 
 * 类 @code(SpiTest)
 *
 * <p>
 *  功能简介：
 * <p>
* Spi使用示例类
 * <p>
 *  创建时间：2019年9月9日
 *
 * @author chenxj
 */
public class SpiTest {
	
	public static void main(String[] args) {
		ServiceLoader<Search> serviceLoader = ServiceLoader.load(Search.class);
		Iterator<Search> it = serviceLoader.iterator();
		while(it.hasNext()) {
			Search printImpl = it.next();
			printImpl.print();
		}
	}
}
