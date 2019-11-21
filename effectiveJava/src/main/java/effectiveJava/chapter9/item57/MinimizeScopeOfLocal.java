package effectiveJava.chapter9.item57;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * 类 @code(MinimizeScopeOfLocal)
 *
 * <p>
 * 功能简介：
 * <p>
 * 用于最小化局部变量作用域的最强大的技术是再首次使用的地方声明它。 如果变量在使用之前被声明，那就变得更加混乱——
 * 这也会对试图理解程序的读者来讲，又增加了一件分散他们注意力的事情。 到使用该变量时，读者可能不记得变量的类型或初始值。
 * 过早地声明局部变量可能导致其作用域不仅过早开始而且结束太晚。 局部变量的作用域从声明它的位置延伸到封闭块的末尾。
 * 如果变量在使用它的封闭块之外声明，则在程序退出该封闭块后它仍然可见。如果在其预定用途区域之前或之后意外使用变量，则后果可能是灾难性的
 * 
 * 最小化局部变量演示，for循环本身就确保了变量作用与循环内，优于while语句
 * <p>
 * 创建时间：2019年5月10日
 *
 * @author chenxj
 */
public class MinimizeScopeOfLocal {

	public static void main(String[] args) {
		List<String> c = new ArrayList<>();
		// Preferred idiom for iterating over a collection or array
		for (@SuppressWarnings("unused")
		String e : c) {
			// Do Something with e
		}

		// Idiom for iterating when you need the iterator
		for (Iterator<String> i = c.iterator(); i.hasNext();) {
			@SuppressWarnings("unused")
			String e = i.next();
			// Do something with e and i
		}
		// i本应该是第一个循环的局部变量，因为while没有控住局部变量的作用域
		Iterator<String> i = c.iterator();
		while (i.hasNext()) {
			i.next();
		}
		List<String> c2 = new ArrayList<>();
		Iterator<String> i2 = c2.iterator();
		while (i.hasNext()) { // BUG!
			i2.next();
		}
		// 第二个变量n用于存储第一个变量的限定值，从而避免了每次迭代中冗余计算的代价。作为一个规则，如果循环测试涉及一个方法调用，并且保证在每次迭代中返回相同的结果，那么应该使用这种用法
		for (int j = 0, n = expensiveComputation(); j < n; j++) {
			// Do something with i;
		}
	}

	private static int expensiveComputation() {

		return 0;
	}
}
