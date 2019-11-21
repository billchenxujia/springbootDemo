package com.example.demo.json;

import com.example.demo.bean.response.ResponseMessage;
import com.google.gson.Gson;

/**
 * 
 * 类 @code(JsonTest)
 *
 * <p>
 *  功能简介：
 * <p>
* json测试类
 * <p>
 *  创建时间：2019年8月23日
 *
 * @author chenxj
 */
public class JsonTest {
	public static void main(String[] args) {
		Gson gson = new Gson();
		ResponseMessage message = new ResponseMessage();
		
		System.out.println(gson.toJson(message));
	}
}
