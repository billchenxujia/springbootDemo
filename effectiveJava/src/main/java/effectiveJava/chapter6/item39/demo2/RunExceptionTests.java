package effectiveJava.chapter6.item39.demo2;

import java.lang.reflect.Method;

/**
 * 
 * 类 @code(RunExceptionTests)
 *
 * <p>
 * 功能简介：
 * <p>
 * 框架使用注解简单演示
 * <p>
 * 创建时间：2019年4月16日
 *
 * @author chenxj
 */
public class RunExceptionTests {
	public static void main(String[] args) throws Exception {
		int tests = 0;
		int passed = 0;
		Class<?> testClass = Class.forName(args[0]);
		for (Method m : testClass.getDeclaredMethods()) {
			tests++;
			try {
				m.invoke(null);
				System.out.printf("Test %s failed: no exception%n", m);
			} catch (Throwable wrappedExc) {
				Throwable exc = wrappedExc.getCause();
				int oldPassed = passed;
				ExceptionTest[] excTests =
						m.getAnnotationsByType(ExceptionTest.class);
				for (ExceptionTest excTest : excTests) {
					if (excTest.value().isInstance(exc)) {
						passed++;
						break;
					}
				}
				if (passed == oldPassed)
					System.out.printf("Test %s failed: %s %n", m, exc);
			}
		}
		System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
	}
}
