package effectiveJava.chapter11.item78;

import java.util.concurrent.TimeUnit;

/**
 * 
 * 类 @code(StopThreadFail)
 *
 * <p>
 * 功能简介：
 * <p>
 * 并发编程演示： 这种读写未同步的代码，行为具有不确定性，非常脆弱。 编译器优化后，可能会导致永远都线程永远都不会终止。
 * <p>
 * 创建时间：2019年5月29日
 *
 * @author chenxj
 */
public class StopThreadFail {
	private static boolean stopRequested;

	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread = new Thread(() -> {
			@SuppressWarnings("unused")
			int i = 0;
			while (!stopRequested)
				i++;
		});
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
		stopRequested = true;
	}
}
