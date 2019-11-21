package effectiveJava.chapter12.item87;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//StringList with a reasonable custom serialized form
/**
 * 
 * 类 @code(StringList)
 *
 * <p>
 * 功能简介：
 * <p>
 * StringList的合理序列化形式，就是列表中的字符串数量，然后紧跟着字符串本身。这构成了由StringList表示的逻辑数据，去掉了其物理表示的细节。下面是修改后的StringList版本，包含实现此序列化形式的writeObject和readObject方法。提醒一下，transient修饰符表示要从类的默认序列化形式中省略一个实例属性:
 * 
 * <p>
 * 创建时间：2019年6月13日
 *
 * @author chenxj
 */
public final class StringList implements Serializable {

	private static final long serialVersionUID = 7233528724901052703L;
	private transient int size = 0;
	private transient Entry head = null;

	// No longer Serializable!
	private static class Entry {
		String data;
		Entry next;
		@SuppressWarnings("unused")
		Entry previous;
	}

	// Appends the specified string to the list
	public final void add(String s) {
	}

	/**
	 * Serialize this {@code StringList} instance.
	 *
	 * @serialData The size of the list (the number of strings it contains) is
	 *             emitted ({@code int}), followed by all of its elements (each a
	 *             {@code String}), in the proper sequence.
	 */
	private void writeObject(ObjectOutputStream s) throws IOException {
		s.defaultWriteObject();
		s.writeInt(size);

		// Write out all elements in the proper order.
		for (Entry e = head; e != null; e = e.next)
			s.writeObject(e.data);
	}

	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
		s.defaultReadObject();
		int numElements = s.readInt();

		// Read in all elements and insert them in list
		for (int i = 0; i < numElements; i++)
			add((String) s.readObject());
	}

}