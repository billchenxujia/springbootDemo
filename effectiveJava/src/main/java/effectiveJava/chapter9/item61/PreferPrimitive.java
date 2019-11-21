package effectiveJava.chapter9.item61;

import java.util.Comparator;

/**
 * 
 * 类 @code(PreferPrimitive)
 *
 * <p>
 * 功能简介：
 * <p>
 * 基本类型和包装基本类型之间有三个主要区别。首先，基本类型只有它们的值，而包装基本类型具有与其值不同的标识。换句话说，两个包装基本类型实例可以具有相同的值但不同的引用标识。第二，基本类型只有功能的值（functional
 * value），而每个包装基本类型类型除了对应的基本类型的功能值外，还有一个非功能值，即null。最后，基本类型比包装的基本类型更节省时间和空间。如果你不小心的话，这三种差异都会给你带来真正的麻烦。
 * <p>
 * 创建时间：2019年5月16日
 *
 * @author chenxj
 */
public class PreferPrimitive {
	
	public static void main(String[] args) {
		// Broken comparator - can you spot the flaw?
		@SuppressWarnings("unused")
		Comparator<Integer> naturalOrderError =
		    (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);
		    
		@SuppressWarnings("unused")
		Comparator<Integer> naturalOrder = (iBoxed, jBoxed) -> {
			int i = iBoxed, j = jBoxed; // Auto-unboxing
			return i < j ? -1 : (i == j ? 0 : 1);
		};
	}
}
