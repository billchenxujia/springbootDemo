package effectiveJava.chapter11.item81;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * 
 * 类 @code(ConcurrencyUtilities)
 *
 * <p>
 * 功能简介：
 * <p>
 * 并发使用程序演示
 * <p>
 * 创建时间：2019年6月10日
 *
 * @author chenxj
 */
public class ConcurrencyUtilities {

	public static void main(String[] args) {

	}

	// Concurrent canonicalizing map atop ConcurrentMap - not optimal
	private static final ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

	public static String intern(String s) {
		String previousValue = map.putIfAbsent(s, s);
		return previousValue == null ? s : previousValue;
	}

	// Concurrent canonicalizing map atop ConcurrentMap - faster!
	public static String internOptimize(String s) {
		String result = map.get(s);
		if (result == null) {
			result = map.putIfAbsent(s, s);
			if (result == null)
				result = s;
		}
		return result;
	}

	// Simple framework for timing concurrent execution
	public static long time(Executor executor, int concurrency, Runnable action) throws InterruptedException {
		CountDownLatch ready = new CountDownLatch(concurrency);
		CountDownLatch start = new CountDownLatch(1);
		CountDownLatch done = new CountDownLatch(concurrency);

		for (int i = 0; i < concurrency; i++) {
			executor.execute(() -> {
				ready.countDown(); // Tell timer we're ready
				try {
					start.await(); // Wait till peers are ready
					action.run();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				} finally {
					done.countDown(); // Tell timer we're done
				}
			});
		}
		ready.await(); // Wait for all workers to be ready
		long startNanos = System.nanoTime();
		start.countDown(); // And they're off!
		done.await(); // Wait for all workers to finish
		return System.nanoTime() - startNanos;
	}
}
