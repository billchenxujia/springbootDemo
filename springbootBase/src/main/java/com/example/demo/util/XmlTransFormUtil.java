package com.example.demo.util;

import org.apache.http.util.TextUtils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 
 * 类 @code(XmlUtil)
 *
 * <p>
 *  功能简介：
 * <p>
* xmlBean互相转换工具类演示
 * <p>
 *  创建时间：2019年9月4日
 *
 * @author chenxj
 */
public class XmlTransFormUtil {
	
	private XmlTransFormUtil() {
		throw new AssertionError("工具类不能调用构造器");
	}
	

	/**
	 * xml转对象
	 * @param <T> 对象类型
	 * @param xmlStr 
	 * @param cls
	 * @return
	 */
	public static <T> T toBean(String xmlStr, Class<T> cls) {
        if (TextUtils.isEmpty(xmlStr) || xmlStr.contains("Error")) {
            return null;
        }
        try {
            XStream xstream = new XStream(new DomDriver());
            //忽略不需要的节点
            xstream.ignoreUnknownElements();
            //对指定的类使用Annotations 进行序列化
            xstream.processAnnotations(cls);
            @SuppressWarnings("unchecked")//转换出现异常会被try-catch捕获，不需要
			T obj = (T) xstream.fromXML(xmlStr);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
