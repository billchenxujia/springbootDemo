package effectiveJava.chapter11.item78;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 
 * 类 @code(ShareVariant)
 *
 * <p>
 * 功能简介：
 * <p>
 * 自增操作不是原子性的: AtomicLong类，它是java.util.concurrent.atomic包下的一部分。
 * 这个包为单个变量提供了无锁，线程安全编程的基本类型。 虽然volatile只提供同步的通信效果，但这个包还提供了原子性。
 * 这正是我们想要的generateSerialNumber，它可能强于同步版本的代码
 * 
 * <p>
 * 创建时间：2019年5月29日
 *
 * @author chenxj
 */
public class ShareVariant {

	// Broken - requires synchronization!
	private static volatile int nextSerialNumber = 0;

	public static int generateSerialNumber() {
		return nextSerialNumber++;
	}

	// Lock-free synchronization with java.util.concurrent.atomic
	private static final AtomicLong nextSerialNum = new AtomicLong();

	public static long generateSerialNumberByAtomic() {
		return nextSerialNum.getAndIncrement();
	}
}
