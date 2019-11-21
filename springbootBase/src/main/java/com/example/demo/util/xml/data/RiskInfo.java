package com.example.demo.util.xml.data;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * 类 @code(RiskInfo)
 *
 * <p>
 *  功能简介：
 * <p>
* riskInfo模拟
 * <p>
 *  创建时间：2019年9月8日
 *
 * @author chenxj
 */
@XStreamAlias("RiskInfo")
public class RiskInfo implements BaseCommInfo {
	@XStreamAlias("RiskId")
	private String riskId;
	@XStreamAlias("RiskName")
	private String riskName;
	public String getRiskId() {
		return riskId;
	}
	public void setRiskId(String riskId) {
		this.riskId = riskId;
	}
	public String getRiskName() {
		return riskName;
	}
	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}
	
}
