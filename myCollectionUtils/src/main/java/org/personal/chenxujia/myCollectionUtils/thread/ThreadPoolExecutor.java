package org.personal.chenxujia.myCollectionUtils.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 
 * 类 @code(ThreadPoolExecutor)
 *
 * <p>
 *  功能简介：
 * <p>
* 默认线程池使用演示
 * <p>
 *  创建时间：2019年5月22日
 *
 * @author chenxj
 */
public class ThreadPoolExecutor {
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService excutor = Executors.newFixedThreadPool(1<<2,new ThreadFactory() {			
			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r,"firstThreadDemo_"+r.hashCode());
			}
		});
		Runnable run = new Runnable() {			
			@Override
			public void run() {				
				System.out.println("this is my firstTask");
			}
		};
		excutor.submit(run);
		excutor.awaitTermination(3, TimeUnit.SECONDS);
		excutor.shutdown();
	}
}
