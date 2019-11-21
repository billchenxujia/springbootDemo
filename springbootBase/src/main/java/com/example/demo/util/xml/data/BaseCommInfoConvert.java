package com.example.demo.util.xml.data;

import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * 
 * 类 @code(BaseCommInfoConvert)
 *
 * <p>
 *  功能简介：
 * <p>
* 增加xml内容对泛型的支持转换类
 * <p>
 *  创建时间：2019年9月8日
 *
 * @author chenxj
 */
@XStreamConverter(BaseCommInfoConvert.class)
public class BaseCommInfoConvert implements Converter {

	@Override
	public boolean canConvert(@SuppressWarnings("rawtypes") Class type) {		
		return type.equals(BaseCommInfo.class);
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		String nodeName = reader.getNodeName();
	
		try {
			@SuppressWarnings("unchecked")
			Class<BaseCommInfo> nodeClass = (Class<BaseCommInfo>) Class.forName(nodeName);
			Object instance = nodeClass.newInstance();
			context.convertAnother(instance, nodeClass);
			return instance;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			System.out.println("当前节点未定义相应的实体类");
			e.printStackTrace();
		}
		return null;
	}

}
