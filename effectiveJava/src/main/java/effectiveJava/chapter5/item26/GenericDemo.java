package effectiveJava.chapter5.item26;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 类 @code(GenericDemo)
 *
 * <p>
 * 功能简介：
 * <p>
 * 泛型核心目的，安全性，表达性，明确指定相关类型，让编译器在编译器 做好校验，并在编译后的class里加入必然成功的类型转换，泛型在runtime的信息
 * 会被擦除掉，因此在java中，在类的字面量是需要使用泛型原始类型，以及instance of 中也需要使用。除以上两种情形，都应禁止使用泛型原始类型。
 * <p>
 * 创建时间：2019年4月8日
 *
 * @author chenxj
 */
public class GenericDemo {
	// 运行时失败 - unsafeAdd方法使用了原生类型(List)!
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		unsafeAdd(strings, Integer.valueOf(42));
		//演示错误，故使用了镇压警告
		@SuppressWarnings("unused")
		String s = strings.get(0); // 编译器产生的强转
	}
	//演示错误，故使用了镇压警告
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void unsafeAdd(List list, Object o) {
		list.add(o);
	}
}
