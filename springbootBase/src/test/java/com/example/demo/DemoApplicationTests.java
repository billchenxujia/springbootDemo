package com.example.demo;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.demo.bean.request.RequestMessage;
import com.example.demo.util.JsonUtil;


public class DemoApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testHttp() {
		RestTemplate restTemplate=new RestTemplate();
		String url="http://localhost:8080/test";
		/* 注意：必须 http、https……开头，不然报错，浏览器地址栏不加 http 之类不出错是因为浏览器自动帮你补全了 */
		HttpHeaders headers = new HttpHeaders();
		/* 这个对象有add()方法，可往请求头存入信息 */       
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		/* 解决中文乱码的关键 , 还有更深层次的问题 关系到 StringHttpMessageConverter，先占位，以后补全*/ 
		HttpEntity<String> entity = new HttpEntity<String>(buildBody(), headers);
		/* body是Http消息体例如json串 */
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		System.out.println(response.getBody());
	}			
			
	private static String buildBody() {
		String body = "";
		RequestMessage request = new RequestMessage();
		request.setSubTxn("100001");
//		request.setTxnType("1000");
		request.setReqData("test");
		body = JsonUtil.toJson(request);
		return body;
	}
}
