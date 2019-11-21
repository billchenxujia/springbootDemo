package org.personal.chenxujia.myCollectionUtils.thread.nonReentrantLock;

/**
 * 
 * 类 @code(Lock)
 *
 * <p>
 *  功能简介：
 * <p>
* 不可重入锁简单演示
 * <p>
 *  创建时间：2019年6月8日
 *
 * @author chenxj
 */
public class Lock {
	private boolean isLocked = false;
	
	public synchronized void lock() throws InterruptedException{
		while(isLocked) {
			this.wait();
		}
		isLocked = true;
	}
	
	public synchronized void unlock() {
		isLocked = false;
		this.notify();
	}
}
