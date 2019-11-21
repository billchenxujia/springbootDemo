package com.example.demo.util.xml.data;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * 类 @code(BaseInfo)
 *
 * <p>
 *  功能简介：
 * <p>
* 上送商户基本信息类定义
 * <p>
 *  创建时间：2019年9月6日
 *
 * @author chenxj
 */
@XStreamAlias("BaseInfo")
public class BaseInfo implements BaseCommInfo{
	@XStreamAlias("CusType")
	private String cusType;
	@XStreamAlias("CusNature")
	private String cusNature;
	public String getCusType() {
		return cusType;
	}
	public void setCusType(String cusType) {
		this.cusType = cusType;
	}
	public String getCusNature() {
		return cusNature;
	}
	public void setCusNature(String cusNature) {
		this.cusNature = cusNature;
	}
	
	
}
