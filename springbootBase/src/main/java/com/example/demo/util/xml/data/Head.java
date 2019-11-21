package com.example.demo.util.xml.data;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * 类 @code(SeltCommHead)
 *
 * <p>
 *  功能简介：
 * <p>
* 清算协会综合服务平台未登录头部定义
 * <p>
 *  创建时间：2019年9月4日
 *
 * @author chenxj
 */
@XStreamAlias("Head")
public class Head{
	/**版本号，默认1.2.0*/
	@XStreamAlias("Version")
	private String version;
	/**报文唯一标识（8位日期+10顺序号）*/
	@XStreamAlias("Identification")
	private String identification;
	/**收单机构号（对于成都银行来讲04296510）*/
	@XStreamAlias("OrigSender")
	private String origSender;
	/**收单机构发送系统号（字母、数字、下划线）*/
	@XStreamAlias("OrigSenderSID")
	private String origSenderSID;
	/**协会系统编号，特约信息上报和删除为SECB01,其余R0001*/
	@XStreamAlias("recSystemId")
	private String recSystemId;
	/**交易码，见报文分类列表*/
	@XStreamAlias("TrnxCode")
	private String trnxCode;
	/**交易时间，格式：yyyyMMDDHHmmss(数字)*/
	@XStreamAlias("TrnxTime")
	private String trnxTime;
	/**密钥*/
	@XStreamAlias("SecretKey")
	private String secretKey;
	/**
	 * 登陆token：
	 * 需调用登陆接口获取 除非主动登出，或者
	 * 清算协会综合平台强制退出失效。
	 */
	@XStreamAlias("UserToken")
	private String userToken;
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public String getOrigSender() {
		return origSender;
	}
	public void setOrigSender(String origSender) {
		this.origSender = origSender;
	}
	public String getOrigSenderSID() {
		return origSenderSID;
	}
	public void setOrigSenderSID(String origSenderSID) {
		this.origSenderSID = origSenderSID;
	}
	public String getRecSystemId() {
		return recSystemId;
	}
	public void setRecSystemId(String recSystemId) {
		this.recSystemId = recSystemId;
	}
	public String getTrnxCode() {
		return trnxCode;
	}
	public void setTrnxCode(String trnxCode) {
		this.trnxCode = trnxCode;
	}
	public String getTrnxTime() {
		return trnxTime;
	}
	public void setTrnxTime(String trnxTime) {
		this.trnxTime = trnxTime;
	}
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	
}
