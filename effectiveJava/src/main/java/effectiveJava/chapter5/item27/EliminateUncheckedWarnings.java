package effectiveJava.chapter5.item27;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 类 @code(EliminateUncheckedWarnings)
 *
 * <p>
 * 功能简介：
 * <p>
 * 消除未受检警告
 * <p>
 * 总之，非受检警告是重要的。不要忽略它们。每个非受检警告代表着运行时ClassCastException的可能。尽最大的努力消除这些警告。如果你不能消除非受检警告，而且你可以证明调用它的代码是安全的，那么用@SuppressWarnings("unchecked")注解在尽可能窄的范围内抑制这个警告。为在注释中抑制警告这个决定，标明基本的阐述。
 * 
 * <p>
 * 创建时间：2019年4月8日
 *
 * @author chenxj
 */
public class EliminateUncheckedWarnings {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Set<String> exaltation = new HashSet<>();
	}
}
