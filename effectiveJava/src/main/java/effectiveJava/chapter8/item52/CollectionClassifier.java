package effectiveJava.chapter8.item52;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Broken! - What does this program print?
/**
 * 
 * 类 @code(CollectionClassifier)
 *
 * <p>
 * 功能简介：
 * <p>
 * 慎重使用重载演示： 因为重写是规范，而重载是例外，所以重写设置了人们对方法调用行为的期望。
 * 正如CollectionClassifier示例所示，重载很容易混淆这些期望。 编写让程序员感到困惑的代码的行为是不好的实践。 对于API尤其如此。
 * 如果API的日常用户不知道将为给定的参数集调用多个方法重载中的哪一个，则使用API可能会导致错误。
 * 这些错误很可能表现为运行时的不稳定行为，许多程序员很难诊断它们。 因此，应该避免混淆使用重载。
 * 
 * <p>
 * 创建时间：2019年5月7日
 *
 * @author chenxj
 */
public class CollectionClassifier {

	public static String classify(Set<?> s) {
		return "Set";
	}

	public static String classify(List<?> lst) {
		return "List";
	}

	public static String classify(Collection<?> c) {
		return "Unknown Collection";
	}

	public static void main(String[] args) {

		Collection<?>[] collections = { new HashSet<String>(), new ArrayList<BigInteger>(),
				new HashMap<String, String>().values() };
		for (Collection<?> c : collections)
			System.out.println(classify(c));
	}

}
