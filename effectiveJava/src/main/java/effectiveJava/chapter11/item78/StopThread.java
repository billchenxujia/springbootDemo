package effectiveJava.chapter11.item78;

import java.util.concurrent.TimeUnit;

//Properly synchronized cooperative thread termination
/**
 * 
 * 类 @code(StopThread)
 *
 * <p>
 * 功能简介：
 * <p>
 * 同步读写确保了线程行为的稳定性。不会出现并发问题 出long、double以外 java语言本身确保了其他基本类型的读和写的操作的原子性
 * 但是需要注意的是，因此就只对基本类型（long、double除外）单独做读或者写
 * 的同步，本身依然不能保证并发安全。原因是，读值的瞬间并不能确保其他线程的写 操作对你是可见的。反之，同理
 * <p>
 * 创建时间：2019年5月29日
 *
 * @author chenxj
 */
public class StopThread {
	private static boolean stopRequested;

	private static synchronized void requestStop() {
		stopRequested = true;
	}

	private static synchronized boolean stopRequested() {
		return stopRequested;
	}

	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(() -> {
			@SuppressWarnings("unused")
			int i = 0;
			while (!stopRequested())
				i++;
		});

		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
		requestStop();
	}
}