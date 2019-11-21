package effectiveJava.chapter2.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 
 * 类 @code(Stack)
 *
 * <p>功能简介：
 *
 * <p>没有排除废弃的对象引用导致的内存溢出演示
 * 
 * <p>大部分情况下需要特别的注意的是：自我管理内存分配的类，这种类中的element
 * gc是无法知道是否有用的，只有程序员自己知道。因此当其没用时，应该及时将其
 * 对象引用赋值为null。
 * <p>但是通常来讲，不论一个类是否自我管理内存，当一个element不再使用时，程序员
 * 都应该将它赋值为null。
 * 
 * <p>注1：内存泄露是一个可以潜藏很多年的问题，而且排查需要非常专业的工具比如heap profiler
 * 加上非常细致的代码比对，因此提前学会并预防比后面去排查显得非常重要
 * 
 * <p>注2：缓存以及监听器和回调函数也是可能出现内存泄露的两个地方
 * 简单的缓存实现可以通过使用{@code WeakHashMap}这个非常有用的类来，较为复杂的
 * 可以参考{@code LinkedHashMap removeEldestEntry }方法来实现，更为复杂常见的则可能需要用到
 * java.lang.ref来解决。
 * 
 * <p>注册回调函数，没有明确撤销注册也容易引发这个问题，一个方式是敏捷地确认这些
 * 回调函数已经被垃圾回收器标记为弱引用。例如对于实例，将他们以键的形式存储在WeakHashMap
 * 
 * <p>创建时间：2019年3月23日
 *
 * @author chenxj
 */
public class Stack {
	
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITAL_CAPACITY = 16;
	
	public Stack() {
		elements = new  Object[DEFAULT_INITAL_CAPACITY];
	}
	
	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}
	
	/**
	 * 内存溢出的原因：
	 * <p>未能排除废弃的引用
	 * <p>
	 * @return
	 */
	public Object pop() {
		if(size == 0)
			throw new EmptyStackException();
//		Object result = elements[--size];
//		elements[size] = null;//Eliminate obsolete reference
//		return result; 
//上面三段代码就是排除废弃引用后的改进版本可以避免内存溢出；
//一个赋予null值的额外的好处是这个废弃的引用不会因为失误而被关联到对象上！
//这段程序将会立马通过空指针异常失败，而不是静静地保持错误。
//这对排错是有好处的
		return elements[--size];
	}
	
	/**
	 * 用于确保对象数组可以继续放入对象的扩容方法
	 */
	private void ensureCapacity() {
		
		if(elements.length == size)
			elements = Arrays.copyOf(elements,  2 * size + 1);
	}
	
}
