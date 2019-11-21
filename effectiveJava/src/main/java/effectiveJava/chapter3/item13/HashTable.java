package effectiveJava.chapter3.item13;

/**
 * 
 * 类 @code(HashTable)
 *
 * <p>功能简介：
 *
 * <p>clone深拷贝演示
 * <p>这是构建的一个非常简单的hashTable，
 * 链有内部的Entry类构造出了一个简单的的链表，为实现clone递归调用
 *
 * <p>创建时间：2019年3月27日
 *
 * @author chenxj
 */
public class HashTable implements Cloneable {

	private final int DEFAULT_INITIAL_CAPACITY = 16;
	private Entry[] buckets;
	
	public HashTable() {
		buckets = new Entry[DEFAULT_INITIAL_CAPACITY];
	}
	public HashTable(int size) {
		buckets = new Entry[size];
	}
	private static class Entry {
		final Object key;
		Object value;
		Entry next;

		Entry(Object key, Object value, Entry next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
		// 递归地拷贝由这个Entry开头的链表
        Entry deepCopy() {
            return new Entry(key, value,
                next == null ? null : next.deepCopy());
        }
	}

	// 逐层递归clone;
	@Override
	public HashTable clone() {
		try {
            HashTable result = (HashTable) super.clone();
            result.buckets = new Entry[buckets.length];
            for (int i = 0; i < buckets.length; i++)
                if (buckets[i] != null)
                    result.buckets[i] = buckets[i].deepCopy();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
	}
	//不支持Cloneable的可扩展类的clone方法 ,clone重写一般不推荐。
	//所以可以通过final避免子类随意实现引发不必要的问题
	/*
	 * @Override protected final Object clone() throws CloneNotSupportedException {
	 * throw new CloneNotSupportedException(); }
	 */
}