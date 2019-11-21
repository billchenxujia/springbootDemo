package effectiveJava.chapter8.item53;

/**
 * 
 * 类 @code(VarargsDemo)
 *
 * <p>
 * 功能简介：
 * <p>
 * 可变参数使用示例：
 * 总之，当需要使用可变数量的参数定义方法时，可变参数非常有用。 在使用可变参数前加上任何必需的参数，并注意使用可变参数的性能后果。
 * <p>
 * 创建时间：2019年5月8日
 *
 * @author chenxj
 */
public class VarargsDemo {

	// Simple use of varargs
	static int sum(int... args) {
		int sum = 0;
		for (int arg : args)
			sum += arg;
		return sum;
	}

	// The WRONG way to use varargs to pass one or more arguments!
	static int min(int... args) {
		if (args.length == 0)
			throw new IllegalArgumentException("Too few arguments");
		int min = args[0];
		for (int i = 1; i < args.length; i++)
			if (args[i] < min)
				min = args[i];
		return min;
	}

	// The right way to use varargs to pass one or more arguments
	static int min(int firstArg, int... remainingArgs) {
		int min = firstArg;
		for (int arg : remainingArgs)
			if (arg < min)
				min = arg;
		return min;
	}

	// 在性能关键的情况下使用可变参数时要小心。每次调用可变参数方法都会导致数组分配和初始化。如果你从经验上确定负担不起这个成本，但是还需要可变参数的灵活性，那么有一种模式可以让你鱼与熊掌兼得。假设你已确定95％的调用是三个或更少的参数的方法，那么声明该方法的五个重载。每个重载方法包含0到3个普通参数，当参数数量超过3个时，使用一个可变参数方法:
	public void foo() {
	}

	public void foo(int a1) {
	}

	public void foo(int a1, int a2) {
	}

	public void foo(int a1, int a2, int a3) {
	}

	public void foo(int a1, int a2, int a3, int... rest) {
	}
}
