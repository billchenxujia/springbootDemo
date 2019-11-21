package effectiveJava.chapter7.item47;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * 类 @code(PowerSet)
 *
 * <p>
 * 功能简介：
 * <p>
 *  优先使用Collection而不是Stream来作为方法的返回类型
 * <p>
 * 创建时间：2019年4月30日
 *
 * @author chenxj
 */
//Returns the power set of an input set as custom collection
public class PowerSet {
	public static final <E> Collection<Set<E>> of(Set<E> s) {
		List<E> src = new ArrayList<>(s);
		if (src.size() > 30)
			throw new IllegalArgumentException("Set too big " + s);
		return new AbstractList<Set<E>>() {
			
			@Override
			public int size() {
				return 1 << src.size(); // 2 to the power srcSize
			}

			@SuppressWarnings("rawtypes")
			@Override
			public boolean contains(Object o) {
				return o instanceof Set && src.containsAll((Set) o);
			}
			
			@Override
			public Set<E> get(int index) {
				Set<E> result = new HashSet<>();
				for (int i = 0; index != 0; i++, index >>= 1)
					if ((index & 1) == 1)
						result.add(src.get(i));
				return result;
			}
		};
	}

}