package com.example.demo.util.xml.data;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * 
 * 类 @code(PracList)
 *
 * <p>
 *  功能简介：
 * <p>
* 上送列表定义
 * <p>
 *  创建时间：2019年9月6日
 *
 * @author chenxj
 */
@XStreamAlias("PracList")
public class PracList<T extends BaseCommInfo> {
	@XStreamAlias("Count")
	private String count;
	@XStreamImplicit(itemFieldName="BaseInfo")
	private List<T> t;
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public List<T> getT() {
		return t;
	}
	public void setBaseInfo(List<T> t) {
		this.t = t;
	}
	
	
}
