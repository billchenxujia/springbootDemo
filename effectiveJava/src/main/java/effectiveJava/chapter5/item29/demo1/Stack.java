package effectiveJava.chapter5.item29.demo1;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 
 * 类 @code(Stack)
 *
 * <p>
 *  功能简介：
 * <p>
* 使用泛型类示例：最常用的改造为泛型类的方式，
* 但是会造成堆污染，虽然伤害可以忽略不计
 * <p>
 *  创建时间：2019年4月9日
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
     elements =(E[]) new Object[DEFAULT_INITIAL_CAPACITY];;
 }

 public void push(E e) {
     ensureCapacity();
     elements[size++] = e;
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
}
