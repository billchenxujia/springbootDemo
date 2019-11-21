package effectiveJava.chapter7.item43;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 类 @code(MethodReferenceDemo)
 *
 * <p>
 *  功能简介：
 * <p>
* 方法引用演示
 * <p>
 *  创建时间：2019年4月17日
 *
 * @author chenxj
 */
public class MethodReferenceDemo {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<>();
		map.put("hello", 1);
		//用lambda实现合并，但是代码依然得有些臃肿
		map.merge("hello", 1, (count, incr) -> count + incr);
		//从Java 8开始，Integer类（和所有其他包装数字基本类型）提供了一个静态方法总和，和它完全相同。 我们可以简单地传递一个对这个方法的引用，并以较少的视觉混乱得到相同的结果
		map.merge("hello", 1, Integer::sum);
		System.out.println(map);
	}
}
