package effectiveJava.chapter5.item31;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 类 @code(WildCardDemo)
 *
 * <p>
 * 功能简介：
 * <p>
 * 通配符使用演示： 总之，在你的API中使用通配符类型，虽然棘手，但使得API更加灵活。 如果编写一个将被广泛使用的类库，正确使用通配符类型应该被认为
 * 是强制性的。 记住基本规则： producer-extends, consumer-super （PECS）。
 * 还要记住，所有Comparable和Comparator都是消费者。
 * <p>
 * 创建时间：2019年4月10日
 *
 * @author chenxj
 */
public class WildCardDemo {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		list1.add(2);
		list1.add(1);
		System.out.println(list1);
		swap(list1, 0, 1);
		System.out.println(list1);
	}

	public static void swap(List<?> list, int i, int j) {
		swapHelper(list, i, j);
	}

	// Private helper method for wildcard capture
	private static <E> void swapHelper(List<E> list, int i, int j) {
		list.set(i, list.set(j, list.get(i)));
	}
}
