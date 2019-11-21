package effectiveJava.chapter4.item18;

import java.util.Collection;
import java.util.Set;

/**
 * 
 * 类 @code(InstrumentedSet)
 *
 * <p>
 * 功能简介：
 *
 * <p>
 * 包装类 - 使用组合代替继承 (组合优于继承示例)。
 * 继承是强大的，但是它是有问题的，因为它违反了封装性。仅仅当子类和超类之间存在一个真正子类型关系时，这是合适的。即使那样，如果子类是来自不同于超类的包，而且超类不是设计为继承，那么继承可能导致脆弱性。为了避免这个脆弱性，使用组合和转发而不是继承，特别是为实现一个包装类的一个恰当接口存在时。不仅包装类比子类更加强健，而且它们也是更加功能强大的
 * 
 * <p>
 * 创建时间：2019年4月2日
 *
 * @author chenxj
 */
public class InstrumentedSet<E> extends ForwardingSet<E> {
	private int addCount = 0;

	public InstrumentedSet(Set<E> s) {
		super(s);
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
