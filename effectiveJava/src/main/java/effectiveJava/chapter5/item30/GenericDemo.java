package effectiveJava.chapter5.item30;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 类 @code(GenericDemo)
 *
 * <p>
 *  功能简介：
 * <p>
* 泛型方法演示类
 * <p>
 *  创建时间：2019年4月9日
 *
 * @author chenxj
 */
public class GenericDemo {
	
	public static void main(String[] args) {
		Set<String> guys = Set.of("Tom", "Dick", "Harry");
	    Set<String> stooges = Set.of("Larry", "Moe", "Curly");
	    Set<String> aflCio = union(guys, stooges);
	    Set<Integer>  integers =  Set.of(1, 3, 5);
	    Set<Double>   doubles  =  Set.of(2.0, 4.0, 6.0);
	    Set<Number>   numbers  =  union(integers, doubles);
	    System.out.println(aflCio);
	    System.out.println(numbers);

	}
	/**
	 * 联合两个传入set集合的方法
	 * @param <E> 集合申明的类型参数
	 * @param s1 第一个set集合
	 * @param s2 第二个set集合
	 * @return 联合后的set集合
	 */
	public static <E> Set<E> union(Set<? extends E> s1,  Set<? extends E> s2){
		Set<E> result = new HashSet<>(s1);
		result.addAll(s2);
		return result;
	}
}
