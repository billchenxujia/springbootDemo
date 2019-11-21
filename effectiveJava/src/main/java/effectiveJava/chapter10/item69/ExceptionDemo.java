package effectiveJava.chapter10.item69;

/**
 * 
 * 类 @code(ExceptionDemo)
 *
 * <p>
 * 功能简介：
 * <p>
 * 异常处理演示：
 * 如果要在没有外部同步的情况下并发地访问对象，或者受制于外部引发的状态转换，则必须使用Optional的或可区分的返回值，因为在调用状态测试方法与其依赖于状态的方法之间的间隔内，对象的状态可能会发生变化。如果一个单独的状态测试方法将重复依赖于状态的方法的工作，那么性能问题可能要求使用一个Optional的或可区分的返回值。在所有其他条件相同的情况下，状态测试方法略优于区分的返回值。它提供了更好的可读性，而且不正确的使用可能更容易检测：如果忘记调用状态测试方法，依赖于状态的方法将抛出异常，使错误变得明显；如果忘记检查一个可区分的返回值，那么这个bug可能很微妙。这不是Optional返回值的问题。
 * 
 * <p>
 * 创建时间：2019年5月22日
 *
 * @author chenxj
 */
public class ExceptionDemo {

	/**
	 * 
	 * 类 @code(Demo)
	 *
	 * <p>
	 * 功能简介：
	 * <p>
	 * 保证编译通过构造的内部示例类
	 * <p>
	 * 创建时间：2019年5月22日
	 *
	 * @author chenxj
	 */
	private static class Mountain {

		private void climb() {

		}
	}

	public static void main(String[] args) {

		Mountain[] range = new Mountain[100];
		for (int i = 0; i < 100; i++) {
			range[i] = new Mountain();
		}
		long start = System.currentTimeMillis();
		// Horrible abuse of exceptions. Don't ever do this!
		try {

			int i = 0;
			while (true)
				range[i++].climb();
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		long end = System.currentTimeMillis();
		System.out.println("异常检查所用时间" + Long.valueOf((end - start)));
		// 增强for循环解决try-catch滥用
		start = System.currentTimeMillis();
		for (Mountain m : range)
			m.climb();
		end = System.currentTimeMillis();
		System.out.println("增请for所用时间" + Long.valueOf((end - start)));
	}
}
