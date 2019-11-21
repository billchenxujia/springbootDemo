package com.example.demo.util;

import java.io.IOException;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * 类 @code(JsonUtil)
 *
 * <p>
 *  功能简介：
 * <p>
* 简单json工具包
 * <p>
 *  创建时间：2019年6月20日
 *
 * @author chenxj
 */
public class JsonUtil {
		
	private JsonUtil() {
		throw new AssertionError("工具类不能调用构造器");
	}
	
	private static final ObjectMapper mapper = new ObjectMapper();
	/**
	 * 将对象转化为json
	 * @author yangwenkui
	 * @time 2017年3月16日 下午2:55:10
	 * @param obj 待转化的对象
	 * @return 当转化发生异常时返回null
	 */
	public static String toJson(Object obj){
	    if(obj == null){
	        return null;
	    }
	    try {
	        return mapper.writeValueAsString(obj);
	    } catch (IOException e) {
	    	
	        System.out.println("对象转换json异常");
	    }
	    return null;
	}
	
	/**
	 * 将对象转化为json
	 * @author yangwenkui
	 * @time 2017年3月16日 下午2:55:10
	 * @param c 待转化成的类对象
	 * @return  返回转化的类对象
	 */
	public static <T> T fromJson(String json,Class<T> c){
		if (StringUtils.hasLength(json) == false)
            return null;

        T t = null;
        try {
            t = mapper.readValue(json, c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
	}
}
