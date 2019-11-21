package effectiveJava.chapter7.item42;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.*;

/**
 * 
 * 类 @code(LambdaDemo)
 *
 * <p>
 * 功能简介：
 * <p>
 * lambda表达式使用演示：
 * <p>
 * 创建时间：2019年4月16日
 *
 * @author chenxj
 */
public class LambdaDemo {
	public static void main(String[] args) {

		List<String> words = new ArrayList<>();
		words.add("chenxinyu");
		words.add("chenxinyu");
		words.add("limengyun");
		// Anonymous class instance as a function object - obsolete!
		Collections.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		});

		// Lambda expression as function object (replaces anonymous class)
		Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
		//比较器构造方法代替lambda，则代码中的比较器可以变得更加简洁
		Collections.sort(words, comparingInt(String::length));
		//利用添加到Java 8中的List接口的sort方法，可以使片段变得更简短
		words.sort(comparingInt(String::length));
	}
}
