package effectiveJava.chapter4.item20;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

/**
 * 
 * 类 @code(StaticFactoryList)
 *
 * <p>
 * 功能简介：
 *
 * <p>
 * 在AbstractList之上包含了一个完整和完全功能List实现
 * 总而言之，一个接口通常是定义允许多实现的一个类型的最好方法。如果你导出一个非显然的接口，那么你应该仔细考虑为它匹配一个骨架实现。在可能的范围内，你应该通过接口默认方法提供骨架实现，以便这个接口的所有实现可以使用它。也就是说，接口限制通常要求骨架实现以抽象类的方式出现。
 * <p>
 * 创建时间：2019年4月3日
 *
 * @author chenxj
 */
public class StaticFactoryList {
	// 建立于骨架实现上的具体实现
	static List<Integer> intArrayAsList(int[] a) {
		Objects.requireNonNull(a);

		// 菱形操作子只有在在Java9和之后是合法的
		// 如果你使用之前的版本，指定<Integer>
		return new AbstractList<>() {
			@Override
			public Integer get(int i) {
				return a[i]; // 自动装箱(条目6)
			}

			@Override
			public Integer set(int i, Integer val) {
				int oldVal = a[i];
				a[i] = val; // 自动拆箱
				return oldVal; // 自动装箱
			}

			@Override
			public int size() {
				return a.length;
			}
		};
	}
}
