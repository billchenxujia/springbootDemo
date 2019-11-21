package com.example.demo.spi.imp;

import com.example.demo.spi.Search;

/**
 * 
 * 类 @code(WebSearch)
 *
 * <p>
 *  功能简介：
 * <p>
* web搜索实现示例
 * <p>
 *  创建时间：2019年9月9日
 *
 * @author chenxj
 */
public class WebSearch implements Search {

	@Override
	public void print() {
		System.out.println("---------web结果打印------------");
	}

}
