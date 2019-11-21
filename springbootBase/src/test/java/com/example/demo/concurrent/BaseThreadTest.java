package com.example.demo.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * 类 @code(BaseThreadTest)
 *
 * <p>
 *  功能简介：
 * <p>
* 执行器框架执行简单演示
 * <p>
 *  创建时间：2019年8月30日
 *
 * @author chenxj
 */
public class BaseThreadTest {
	
	private static volatile int i = 0;
	public static void main(String[] args) {
				
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for(int j=0;j<10;j++) {
			executorService.execute(new Runnable() {		
				@Override
				public void run() {
					System.out.println(i);
					i++;	
				}
			});
		}
		executorService.shutdown();
	}		
}
