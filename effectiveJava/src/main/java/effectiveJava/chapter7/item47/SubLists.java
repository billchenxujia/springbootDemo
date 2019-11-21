package effectiveJava.chapter7.item47;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//Returns a stream of all the sublists of its input list
/**
 * 
 * 类 @code(SubLists)
 *
 * <p>
 * 功能简介：
 * <p>
 * 总之，在编写返回元素序列的方法时，请记住，某些用户可能希望将它们作为流处理，而其他用户可能希望迭代方式来处理它们。 尽量适应两个群体。
 * 如果返回集合是可行的，请执行此操作。
 * 如果已经拥有集合中的元素，或者序列中的元素数量足够小，可以创建一个新的元素，那么返回一个标准集合，比如ArrayList。
 * 否则，请考虑实现自定义集合，就像我们为幂集程序里所做的那样。 如果返回集合是不可行的，则返回流或可迭代的，无论哪个看起来更自然。
 * 如果在将来的Java版本中，Stream接口声明被修改为继承Iterable，那么应该随意返回流，因为它们将允许流和迭代处理
 * 
 * <p>
 * 创建时间：2019年5月5日
 *
 * @author chenxj
 */
public class SubLists {
	public static <E> Stream<List<E>> of(List<E> list) {
		return Stream.concat(Stream.of(Collections.emptyList()), prefixes(list).flatMap(SubLists::suffixes));
	}

	private static <E> Stream<List<E>> prefixes(List<E> list) {
		return IntStream.rangeClosed(1, list.size()).mapToObj(end -> list.subList(0, end));
	}

	private static <E> Stream<List<E>> suffixes(List<E> list) {
		return IntStream.range(0, list.size()).mapToObj(start -> list.subList(start, list.size()));
	}

}
