package effectiveJava.chapter11.item78;

import java.util.concurrent.TimeUnit;

/**
 * 
 * 类 @code(StopThreadImprove)
 *
 * <p>
 * 功能简介：
 * <p>
 * StopThread中同步方法的操作也是原子性的。换句话说，这些方法上的同步仅用于其通信效果，而不是互斥。虽然在循环的每个迭代上同步的成本很小，但是有一种正确的替代方法，它不那么冗长，而且性能可能更好。如果stoprequest声明为volatile，则可以省略StopThread的第二个版本中的锁定。虽然volatile修饰符不执行互斥，但它保证任何读取属性的线程都会看到最近写入的值
 * <p>
 * 创建时间：2019年5月29日
 *
 * @author chenxj
 */
public class StopThreadImprove {
	private static volatile boolean stopRequested;

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
