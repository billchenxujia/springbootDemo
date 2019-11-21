package com.example.demo.xml;


import java.util.ArrayList;
import java.util.List;

import com.example.demo.util.ClassUtil;
import com.example.demo.util.xml.data.BaseCommInfo;
import com.example.demo.util.xml.data.BaseInfo;
import com.example.demo.util.xml.data.Document;
import com.example.demo.util.xml.data.PracList;
import com.example.demo.util.xml.data.Requst;
import com.example.demo.util.xml.data.Head;
import com.example.demo.util.xml.data.Body;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * 
 * 类 @code(XmlTest)
 *
 * <p>
 *  功能简介：
 * <p>
* XStream使用测试类
 * <p>
 *  创建时间：2019年9月9日
 *
 * @author chenxj
 */
public class XmlTest {

	public static void main(String[] args) {
		
		PracList<BaseInfo> pracList = new PracList<>();
		
		BaseInfo baseInfo1 = new BaseInfo();
		baseInfo1.setCusNature("12");
		baseInfo1.setCusType("01");
		
		BaseInfo baseInfo2 = new BaseInfo();
		baseInfo2.setCusNature("12");
		baseInfo2.setCusType("02");
		
		List<BaseInfo> baseInfo = new ArrayList<>();
		baseInfo.add(baseInfo2);
		baseInfo.add(baseInfo1);
		
		pracList.setBaseInfo(baseInfo);
		
		pracList.setCount("2");
		
		Head head = new Head();
		head.setOrigSender("04296510");
		head.setRecSystemId("R0001");
		Body body = new Body();
		body.setPracList(pracList);
		
		Requst requst = new Requst();
		requst.setHead(head);
		requst.setBody(body);
		
		Document document = new Document();
		document.setSeltCommRequst(requst);
		document.setSignature("signature");
		
		XStream xStream = new XStream(new XppDriver(new NoNameCoder()));
		xStream.ignoreUnknownElements();
		
		loadParseClass(xStream);
					
		// XML序列化
		String documentXml = xStream.toXML(document);
		
		System.out.println(documentXml);

		
		// XML反序列化 
		
		document =(Document) xStream.fromXML(documentXml,document);
		BaseInfo baseInfo3 = (BaseInfo) document.getSeltCommRequst().getBody().getPracList().getT().get(0);
		System.out.println(baseInfo3.getCusNature());
		 
	}
	
	/**
	 * 转换流进行初始化
	 * @param xStream
	 */
	private static void loadParseClass(XStream xStream) {
		//获取继承业务接口的实现类对象
		List<Class<?>> baseList = ClassUtil.getAllClassByInterface(BaseCommInfo.class);
		//初始化需要解析转换的xml类对象数组
		Class<?>[] classes = new Class[5+baseList.size()];
		classes[0]=Head.class;
		classes[1]=Body.class;
		classes[2]=Requst.class;
		classes[3]=Document.class;
		classes[4]=PracList.class;
		
		//讲业务类对象放入其中
		int i = 5;
		for(Class<?> c:baseList ) {			
			classes[i]=c;
			i++;
		}
		xStream.processAnnotations(classes);
		XStream.setupDefaultSecurity(xStream);
		xStream.allowTypes(classes);		
		xStream.aliasSystemAttribute(null, "class"); // 去掉 class 属性 
	}
}
