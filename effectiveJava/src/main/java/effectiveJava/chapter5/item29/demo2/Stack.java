package effectiveJava.chapter5.item29.demo2;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 
 * 类 @code(Stack)
 *
 * <p>
 * 功能简介：
 * <p>
 * 使用泛型类示例：每次读取操作再做强转，不是很常用
 * <p>
 * 创建时间：2019年4月9日
 *
 * @author chenxj
 */
public class Stack<E> {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

//The elements array will contain only E instances from push(E).
//This is sufficient to ensure type safety, but the runtime
//type of the array won't be E[]; it will always be Object[]!
	@SuppressWarnings("unchecked")
	public Stack() {
		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
		;
	}

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public E pop() {
		if (size == 0)
			throw new EmptyStackException();
		// push requires elements to be of type E, so cast is correct
		@SuppressWarnings("unchecked")
		E result = (E) elements[--size];
		elements[size] = null; // Eliminate obsolete reference
		return result;
	}

	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}
}
