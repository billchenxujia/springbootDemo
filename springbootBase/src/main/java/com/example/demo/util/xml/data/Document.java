package com.example.demo.util.xml.data;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * 类 @code(Document)
 *
 * <p>
 *  功能简介：
 * <p>
* 清算协会xml根节点定义
 * <p>
 *  创建时间：2019年9月6日
 *
 * @author chenxj
 */
@XStreamAlias("Document")
public class Document {
	@XStreamAlias("Requst")
	private Requst requst;
	@XStreamAlias("Signature")
	private String signature;
	public Requst getSeltCommRequst() {
		return requst;
	}
	public void setSeltCommRequst(Requst seltCommRequst) {
		this.requst = seltCommRequst;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
}
