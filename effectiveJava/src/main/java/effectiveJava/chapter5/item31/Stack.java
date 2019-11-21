package effectiveJava.chapter5.item31;

import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

/**
 * 
 * 类 @code(Stack)
 *
 * <p>
 * 功能简介：
 * <p>
 * 使用限定通配符类型来增加程序的灵活性
 * <p>
 * 创建时间：2019年4月10日
 *
 * @author chenxj
 */
public class Stack<E> {
	private E[] elements;
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

	// Wildcard type for a parameter that serves as an E producer
	public void pushAll(Iterable<? extends E> src) {
		for (E e : src)
			push(e);
	}

	// Wildcard type for parameter that serves as an E consumer
	public void popAll(Collection<? super E> dst) {
		while (!isEmpty())
			dst.add(pop());
	}

	public E pop() {
		if (size == 0)
			throw new EmptyStackException();
		E result = elements[--size];
		elements[size] = null; // Eliminate obsolete reference
		return result;
	}

	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}

	// 临时用于编译通过
	private boolean isEmpty() {
		return false;
	}
}
