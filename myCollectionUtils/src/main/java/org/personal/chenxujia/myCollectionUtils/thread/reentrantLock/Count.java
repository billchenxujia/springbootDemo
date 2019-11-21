package org.personal.chenxujia.myCollectionUtils.thread.reentrantLock;

/**
 * 
 * 类 @code(Count)
 *
 * <p>
 * 功能简介：
 * <p>
 * 使用可重入锁演示类
 * 我们设计两个线程调用print()方法，第一个线程调用print()方法获取锁，进入lock()方法，由于初始lockedBy是null，所以不会进入while而挂起当前线程，而是是增量lockedCount并记录lockBy为第一个线程。接着第一个线程进入doAdd()方法，由于同一进程，所以不会进入while而挂起，接着增量lockedCount，当第二个线程尝试lock，由于isLocked=true,所以他不会获取该锁，直到第一个线程调用两次unlock()将lockCount递减为0，才将标记为isLocked设置为false。
 * <p>
 * 创建时间：2019年6月8日
 *
 * @author chenxj
 */
public class Count {
	Lock lock = new Lock();

	public void print() throws InterruptedException {
		lock.lock();
		doAdd();
		lock.unlock();
	}

	public void doAdd() throws InterruptedException {
		lock.lock();
		// do something
		lock.unlock();

	}

}
