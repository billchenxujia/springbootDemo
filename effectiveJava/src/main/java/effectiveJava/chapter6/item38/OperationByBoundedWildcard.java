package effectiveJava.chapter6.item38;

import java.util.Arrays;
import java.util.Collection;

/**
 * 
 * 类 @code(OperationByBoundedWildcard)
 *
 * <p>
 *  功能简介：
 * <p>
* 扩展Operation遍历演示
 * <p>
 *  创建时间：2019年4月15日
 *
 * @author chenxj
 */
public class OperationByBoundedWildcard {
	public static void main(String[] args) {
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		test(Arrays.asList(ExtendedOperation.values()), x, y);
	}

	/**
	 * 限定通配符实现遍历并调用传入受限的集合
	 * 
	 * @param opSet 传入的实现Operation的集合
	 * @param x     double操作数x
	 * @param y     double操作数y
	 */
	private static void test(Collection<? extends Operation> opSet, double x, double y) {
		for (Operation op : opSet)
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
	}
}
