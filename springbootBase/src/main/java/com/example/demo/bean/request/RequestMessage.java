package com.example.demo.bean.request;

import javax.validation.constraints.NotBlank;

/**
 * 
 * 类 @code(RequestMessage)
 *
 * <p>
 *  功能简介：
 * <p>
* 请求示例类
 * <p>
 *  创建时间：2019年6月20日
 *
 * @author chenxj
 */
public class RequestMessage {
	
	@NotBlank(message ="txnType不能为空")
	private String txnType;
	@NotBlank(message ="subTxn不能为空")
	private String subTxn;
	@NotBlank(message ="reqData不能为空")
	private String reqData;
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	public String getSubTxn() {
		return subTxn;
	}
	public void setSubTxn(String subTxn) {
		this.subTxn = subTxn;
	}
	public String getReqData() {
		return reqData;
	}
	public void setReqData(String reqData) {
		this.reqData = reqData;
	}
	@Override
	public String toString() {
		return "RequestMessage [txnType=" + txnType + ", subTxn=" + subTxn + ", reqData=" + reqData + "]";
	}
	
	
}
