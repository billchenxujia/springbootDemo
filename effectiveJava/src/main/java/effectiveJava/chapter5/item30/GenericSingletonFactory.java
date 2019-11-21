package effectiveJava.chapter5.item30;

import java.util.List;
import java.util.Objects;
import java.util.function.UnaryOperator;

/**
 * 
 * 类 @code(GenericSingletonFactory)
 *
 * <p>
 * 功能简介：
 * <p>
 * 泛型静态工厂方法演示:
 * <p>
 * 创建时间：2019年4月9日
 *
 * @author chenxj
 */
public class GenericSingletonFactory {
	// Generic singleton factory pattern
	private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

	@SuppressWarnings("unchecked")
	public static <T> UnaryOperator<T> identityFunction() {
		return (UnaryOperator<T>) IDENTITY_FN;
	}

	// Returns max value in a collection - uses recursive type bound
	public static <T extends Comparable<? super T>> T max(List<? extends T> c) {
		if (c.isEmpty())
			throw new IllegalArgumentException("Empty collection");
		T result = null;
		for (T e : c)
			if (result == null || e.compareTo(result) > 0)
				result = Objects.requireNonNull(e);
		return result;
	}

	public static void main(String[] args) {
		String[] strings = { "jute", "hemp", "nylon" };
		UnaryOperator<String> sameString = identityFunction();
		for (String s : strings)
			System.out.println(sameString.apply(s));
		Number[] numbers = { 1, 2.0, 3L };
		UnaryOperator<Number> sameNumber = identityFunction();
		for (Number n : numbers)
			System.out.println(sameNumber.apply(n));
	}
}
