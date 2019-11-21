package com.example.demo.util.xml.factory;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.util.xml.data.BaseCommInfo;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

/**
 * 
 * 类 @code(XStreamFactory)
 *
 * <p>
 * 功能简介：
 * <p>
 * xstreamFactory
 * <p>
 * 创建时间：2019年9月9日
 *
 * @author chenxj
 */
public class XStreamFactory {

	private static volatile Map<String, XStream> streamMap = new HashMap<>();

	private static volatile XStream xStream = null;

	public static XStream getStream(Class<?> tClass) {

		XStream stream=null;

		if(streamMap.containsKey(tClass.getName())) {

			stream=streamMap.get(tClass.getName());

		}else {
			stream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_","_")));

			streamMap.put(tClass.getName(),stream);
		}
		return stream;
	}
	
	public static XStream getXStream(){
		if(xStream == null) {
			xStream = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
		}
		return xStream;		
	}
	
	public static XStream getDocumentXStream(BaseCommInfo baseCommInfo){
		
		
		return xStream;
	}
	
}

		



