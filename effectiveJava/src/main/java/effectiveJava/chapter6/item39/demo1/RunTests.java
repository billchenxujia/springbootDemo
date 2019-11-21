package effectiveJava.chapter6.item39.demo1;

//Program to process marker annotations

import java.lang.reflect.*;

/**
 * 
 * 类 @code(RunTests)
 *
 * <p>
 *  功能简介：
 * <p>
* 注解使用演示（未包含异常处理）
 * <p>
 *  创建时间：2019年4月16日
 *
 * @author chenxj
 */
public class RunTests {

	public static void main(String[] args) throws Exception {
		int tests = 0;
		int passed = 0;
		Class<?> testClass = Class.forName(args[0]);
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(Test.class)) {
				tests++;
				try {
					m.invoke(null);
					passed++;
				} catch (InvocationTargetException wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					System.out.println(m + " failed: " + exc);
				} catch (Exception exc) {
					System.out.println("Invalid @Test: " + m);
				}
			}
		}
		System.out.printf("Passed: %d, Failed: %d%n",
				passed, tests - passed);
	}

}
