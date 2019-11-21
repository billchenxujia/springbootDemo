package com.example.demo.util.xml.data;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 
 * 类 @code(SeltPersonalRiskReportBody)
 *
 * <p>
 *  功能简介：
 * <p>
*	清算协会通用上送报文定义
 * <p>
 *  创建时间：2019年9月5日
 *
 * @author chenxj
 */
@XStreamAlias("Body")
public class Body {
	/**报文实际内容*/
	@XStreamAlias("PracList")
	private PracList<?> pracList;

	public PracList<?> getPracList() {
		return pracList;
	}

	public void setPracList(PracList<?> pracList) {
		this.pracList = pracList;
	}
	
	
}
