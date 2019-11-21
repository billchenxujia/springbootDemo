package effectiveJava.chapter4.item20;

import java.util.Map;
import java.util.Objects;

/**
 * 
 * 类 @code(AbstractMapEntry)
 *
 * <p>
 * 功能简介：
 *
 * <p>
 * 骨架实现类 :
 * 编写骨架实现是一个相当简单的过程，虽然有点单调。首先，研究这个接口，然后决定哪些方法是基元，依据这些，可以实现其他方法。接下来，为直接可以在基元上实现的所有方法，提供接口默认方法，但是回忆到，你可以不提供Object的默认方法，比如equals和hashCode。如果基元和默认方法包括了这个接口，你就完成了，而且对于骨架实现类来说没必要。这个类可能包含了任意一个非公开域和适合这个任务的方法
 * <p>
 * 创建时间：2019年4月3日
 *
 * @author chenxj
 */
public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
	// 可更改映射中的实体必须覆写这个方法
	@Override
	public V setValue(V value) {
		throw new UnsupportedOperationException();
	}

	// 实现Map.Entry.equals的通用协定
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Map.Entry))
			return false;
		@SuppressWarnings("rawtypes")
		Map.Entry<?, ?> e = (Map.Entry) o;
		return Objects.equals(e.getKey(), getKey()) && Objects.equals(e.getValue(), getValue());
	}

	// 实现Map.Entry.hashCode的通用协定
	@Override
	public int hashCode() {
		return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
	}

	@Override
	public String toString() {
		return getKey() + "=" + getValue();
	}
}
