package effectiveJava.chapter4.item18;

import java.util.Collection;
import java.util.HashSet;

/**
 * 
 * 类 @code(InstrumentedHashSet)
 *
 * <p>
 * 功能简介：
 *
 * <p>
 * 继承的不恰当使用示例。（此类非常脆弱）
 *
 * <p>
 * 创建时间：2019年4月2日
 *
 * @author chenxj
 */
@SuppressWarnings("serial")
public class InstrumentedHashSet<E> extends HashSet<E> {
	// 元素尝试插入的数目
	private int addCount = 0;

	public InstrumentedHashSet() {
	}

	public InstrumentedHashSet(int initCap, float loadFactor) {
		super(initCap, loadFactor);
	}

	@Override
	public boolean add(E e) {
		addCount++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(c);
	}

	public int getAddCount() {
		return addCount;
	}
}