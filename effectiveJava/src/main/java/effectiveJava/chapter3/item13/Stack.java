package effectiveJava.chapter3.item13;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 
 * 类 @code(Stack)
 *
 * <p>
 * 功能简介：
 *
 * <p>
 * override clone方法演示：
 * <p>
 * 为不可变类提供clone是不可取的，那样会鼓励浪费copy
 * <p>
 * 1.一般重写，首先调用父类的clone，然后在递归调用子域的clone
 * <p>
 * 2.Cloneable架构，与引用可变对象的final域的正常使用，是不相容的
 * <p>
 * 3.所有实现Cloneable的类应该用公开方法覆写克隆，这个公开方法返回类型是这个类本身。这个方法应该首先调用super.clone，然后修改需要修改的域。通常这意味着，拷贝任何由对象内部“深层结构”组成的可变对象，而且用它们拷贝的引用代替clone的这些对象的引用。虽然这些内部拷贝经常可以递归调用克隆，但是这不总是最好的方案。如果类包含了只有原始类型的域或者对不可变对象的引用，那么域很可能不需要修改。这个规律也有例外情况。比如，一个代表系列码或者其它唯一ID的域，如果它是原始类型或者不可变，那么它需要修改
 * 
 * <p>
 * 创建时间：2019年3月26日
 *
 * @author chenxj
 */
public class Stack implements Cloneable {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public Stack() {
		this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public Object pop() {
		if (size == 0)
			throw new EmptyStackException();
		Object result = elements[--size];
		elements[size] = null; // 消除过期引用
		return result;
	}

	// 保证至少有一个元素的空间
	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}

	// Clone method for class with references to mutable state
	@Override
	public Stack clone() {
		try {
			Stack result = (Stack) super.clone();
			result.elements = elements.clone();
			return result;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.clone();
	}
}
