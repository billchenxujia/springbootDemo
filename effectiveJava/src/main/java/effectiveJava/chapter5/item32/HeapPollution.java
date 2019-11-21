package effectiveJava.chapter5.item32;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * 类 @code(HeapPollution)
 *
 * <p>
 * 功能简介：
 * <p>
 * 混用泛型，可变参数类型引发的堆污染 当参数化类型的变量引用不属于该类型的对象时会发生堆污染（Heap pollution）
 * <p>
 * 总而言之，可变参数和泛型不能很好地交互，因为可变参数机制是在数组上面构建的脆弱的抽象，并且数组具有与泛型不同的类型规则。
 * 虽然泛型可变参数不是类型安全的，但它们是合法的。
 * 如果选择使用泛型（或参数化）可变参数编写方法，请首先确保该方法是类型安全的，然后使用@SafeVarargs注解对其进行标注，以免造成使用不愉快。
 * 
 * 。
 * <p>
 * 创建时间：2019年4月10日
 *
 * @author chenxj
 */
public class HeapPollution {

	// Mixing generics and varargs can violate type safety!
	static void dangerous(@SuppressWarnings("unchecked") List<String>... stringLists) {
		List<Integer> intList = List.of(42);
		Object[] objects = stringLists;
		objects[0] = intList; // Heap pollution
		@SuppressWarnings("unused")
		String s = stringLists[0].get(0); // ClassCastException
	}

	// UNSAFE - Exposes a reference to its generic parameter array!
	@SafeVarargs
	static <T> T[] toArray(T... args) {
		return args;
	}

	/**
	 * 编译此方法时，编译器会生成代码以创建一个将两个T实例传递给toArray的可变参数数组。 这段代码分配了一个Object
	 * []类型的数组，它是保证保存这些实例的最具体的类型，而 不管在调用位置传递给pickTwo的对象是什么类型。 toArray方法只是简单地将这个数组
	 * 返回给pickTwo，然后pickTwo将它返回给调用者，所以pickTwo总是返回一个Object [类型的数组
	 */
	static <T> T[] pickTwo(T a, T b, T c) {
		switch (ThreadLocalRandom.current().nextInt(3)) {
		case 0:
			return toArray(a, b);
		case 1:
			return toArray(a, c);
		case 2:
			return toArray(b, c);
		}
		throw new AssertionError(); // Can't get here
	}

	// Safe method with a generic varargs parameter
	@SafeVarargs
	static <T> List<T> flatten(List<? extends T>... lists) {
		List<T> result = new ArrayList<>();
		for (List<? extends T> list : lists)
			result.addAll(list);
		return result;
	}
	
	// List as a typesafe alternative to a generic varargs parameter
	static <T> List<T> flatten(List<List<? extends T>> lists) {
	    List<T> result = new ArrayList<>();
	    for (List<? extends T> list : lists)
	        result.addAll(list);
	    return result;
	}
}
