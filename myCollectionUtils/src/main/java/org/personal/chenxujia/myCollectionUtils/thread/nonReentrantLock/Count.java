package org.personal.chenxujia.myCollectionUtils.thread.nonReentrantLock;

/**
 * 
 * 类 @code(Count)
 *
 * <p>
 *  功能简介：
 * <p>
* 使用不可重入锁演示类
 * <p>
 *  创建时间：2019年6月8日
 *
 * @author chenxj
 */
public class Count {
	Lock lock = new Lock();
	 public void print() throws InterruptedException{
	        lock.lock();
	        doAdd();
	        lock.unlock();
	    }
	    public void doAdd() throws InterruptedException{
	        lock.lock();
	        //do something
	        lock.unlock();
	    
	    }
	    
}	
