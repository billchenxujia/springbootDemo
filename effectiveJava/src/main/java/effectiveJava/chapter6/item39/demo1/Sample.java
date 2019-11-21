package effectiveJava.chapter6.item39.demo1;

//Program containing marker annotations
/**
 * 
 * 类 @code(Sample)
 *
 * <p>
 *  功能简介：
 * <p>
* 使用注解演示
 * <p>
 *  创建时间：2019年4月16日
 *
 * @author chenxj
 */
public class Sample {

	@Test
	public static void m1() {
	} // Test should pass

	public static void m2() {
	}

	@Test
	public static void m3() { // Test should fail
		throw new RuntimeException("Boom");
	}

	public static void m4() {
	}

	@Test
	public void m5() {
	} // INVALID USE: nonstatic method
	public static void m6() {
	}

	@Test
	public static void m7() { // Test should fail
		throw new RuntimeException("Crash");
	}

	public static void m8() {
	}

}
