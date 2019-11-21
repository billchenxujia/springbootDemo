package com.example.demo.spi.imp;

import com.example.demo.spi.Search;

/**
 * 
 * 类 @code(FileSearch)
 *
 * <p>
 *  功能简介：
 * <p>
* 文件搜索实现示例
 * <p>
 *  创建时间：2019年9月9日
 *
 * @author chenxj
 */
public class FileSearch implements Search {

	@Override
	public void print() {
		System.out.println("---------文件搜索结果打印------------");
	}

}
