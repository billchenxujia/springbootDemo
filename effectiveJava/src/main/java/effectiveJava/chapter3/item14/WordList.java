package effectiveJava.chapter3.item14;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * 类 @code(WordList)
 *
 * <p>
 * 功能简介：
 *
 * <p>
 * Compareble接口实现演示
 * <p>
 * 把指定对象和这个对象依顺序比较。当这个类小于、等于或者大于指定对象时，返回一个负整数、零或者一个正整数。如果指定对象的类别阻止了它同这个对象比较，抛出ClassCastException。
 * 在下面的描述中，把符号sgn(expression)定名为数学上的signum函数，它根据表达式的值是否为负、零或者正，定义为返回-1、0或者1。
 * <p>
 * 1.对于所有的x和y，实现者必须保证sgn(x.compareTo(y)) ==
 * -sgn(y.compareTo(x))。(这意味着，如果而且只有y.compareTo(x)抛出一个异常，x.compareTo(y)必须抛出一个异常。)
 * <p>
 * 2.实现者也必须保证这个关系是可传递的：(x.compareTo(y) > 0 && y.compareTo(z) > 0)意味着x.compareTo(z)
 * > 0。 
 * <p>
 * 3.最后，对于所有的z，实现者必须保证x.compareTo(y) == 0意味着sgn(x.compareTo(z)) ==
 * sgn(y.compareTo(z)) (x.compareTo(y) == 0) ==
 * (x.equals(y))，是强烈建议的，但是不是必要的。通常地讲，实现了Comparable接口而且违反了这个条件的任何类，应该清楚地表明这个事实。推荐的语言是：“注意：这个类有一个自然排序，与equals不一致。”
 * <p>
 * (x.compareTo(y) == 0) == (x.equals(y))，是强烈建议的，但是不是必要的。通常地讲，实现了Comparable接口而且违反了这个条件的任何类，应该清楚地表明这个事实。推荐的语言是：“注意：这个类有一个自然排序，与equals不一致。”
 * <p>
 * 创建时间：2019年3月28日
 *
 * @author chenxj
 */
public class WordList {

	public static void main(String[] args) {

		Set<String> s = new TreeSet<>();
		Collections.addAll(s, args);
		System.out.println(s);

	}
}
