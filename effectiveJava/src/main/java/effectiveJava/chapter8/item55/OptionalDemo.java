package effectiveJava.chapter8.item55;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 
 * 类 @code(OptionalDemo)
 *
 * <p>
 * 功能简介：
 * <p>
 * java8以前某些特定场景服务无法返回任何值时两种解决方案：异常或者null。java8加入了第三种方案Optional<T>
 * Optional<T>类表示一个不可变的容器，它可以包含一个非null的T引用，也可以什么都不包含。不包含任何内容的Optional被称为空（empty）。非空的包含值称的Optional被称为存在（present）。Optional的本质上是一个不可变的集合，最多可以容纳一个元素。Optional<T>没有实现Collection<T>接口，但原则上是可以。
 * 总之，如果发现自己编写的方法不能总是返回值，并且认为该方法的用户在每次调用时考虑这种可能性很重要，那么或许应该返回一个Optional的方法。但是，应该意识到，返回Optional会带来实际的性能后果；对于性能关键的方法，最好返回null或抛出异常。最后，除了作为返回值之外，不应该在任何其他地方中使用Optional。
 * 
 * <p>
 * 创建时间：2019年5月9日
 *
 * @author chenxj
 */
public class OptionalDemo {

	public static void main(String[] args) {
		List<String> words = new ArrayList<>();
		// Using an optional to provide a chosen default value
		String lastWordInLexicon = max(words).orElse("No words...");
		System.out.println(lastWordInLexicon);
		
	}
	
	// Returns maximum value in collection as an Optional<E>
	public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
		if (c.isEmpty())
			return Optional.empty();

		E result = null;
		for (E e : c)
			if (result == null || e.compareTo(result) > 0)
				result = Objects.requireNonNull(e);
		return Optional.of(result);
	}

	// Returns max val in collection as Optional<E> - uses stream
	public static <E extends Comparable<E>> Optional<E> maxUseStream(Collection<E> c) {
		return c.stream().max(Comparator.naturalOrder());
	}
}
