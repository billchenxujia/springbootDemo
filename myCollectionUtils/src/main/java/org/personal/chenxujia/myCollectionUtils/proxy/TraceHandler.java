package org.personal.chenxujia.myCollectionUtils.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 
 * 类 @code(TraceHandler)
 *
 * <p>
 *  功能简介：
 * <p>
* 代理示例类
 * <p>
 *  创建时间：2019年7月5日
 *
 * @author chenxj
 */
class TraceHandler implements InvocationHandler {
	
	private Object target;
	
	
	public TraceHandler(Object t) {
		this.target = t;
	}
	/**
	 * 反射调用
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//打印隐藏参数
		System.out.println(target);
		//打印方法名
		System.out.println("."+method.getName()+"(");
		//打印声明的参数
		if(args != null) {
			for(int i = 0;i<args.length;i++) {
				System.out.println(args[i]);
				if(i < args.length -1) {
					System.out.println(",");
				}
			}			
		}	
		System.out.println(")");
		
		//调用实际的方法
		return method.invoke(target, args);
	}

}
