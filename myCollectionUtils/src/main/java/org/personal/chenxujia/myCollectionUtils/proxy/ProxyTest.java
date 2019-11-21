package org.personal.chenxujia.myCollectionUtils.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * 
 * 类 @code(ProxyTest)
 *
 * <p>
 *  功能简介：
 * <p>
* 代理使用示例
 * <p>
 *  创建时间：2019年7月5日
 *
 * @author chenxj
 */
public class ProxyTest {

	public static void main(String[] args) {
		Object[] elements = new Object[1000];
		
		//为每一个代理填充值
		for(int i=0; i<elements.length;i++ ) {
			Integer value = i+1;
			InvocationHandler handler = new TraceHandler(value);
			Object proxy = Proxy.newProxyInstance(null, new Class[] {Comparable.class},handler);
			elements[i] = proxy;
		}
		//构造随机数
		Integer key = new Random().nextInt(elements.length)+1;
		//搜寻key
		int result = Arrays.binarySearch(elements, key);
		//打印匹配出的结果
		if(result>=0) {
			System.out.println(elements[result]);
		}

	}

}
