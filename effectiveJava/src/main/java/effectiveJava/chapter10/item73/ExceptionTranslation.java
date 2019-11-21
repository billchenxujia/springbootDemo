package effectiveJava.chapter10.item73;

/**
 * 
 * 类 @code(ExceptionTranslation)
 *
 * <p>
 * 功能简介：
 * <p>
 * ，上层（higher layers）应该捕获低层（ lower-level ）的异常，并在它们的位置抛出可以用上层级别（higher-level
 * ）抽象来解释的异常。这个习语被称为异常转译 总之，如果无法阻止或处理较低层的异常，那么使用异常转译，除非较低级别的方法恰好保证其所有异常都适用于较高级别。
 * 异常链接提供了两全其美的优势：它允许抛出适当的更高级别异常，同时可以捕获失败分析的根本原因（
 * <p>
 * 创建时间：2019年5月26日
 *
 * @author chenxj
 */
public class ExceptionTranslation {

	public static void main(String[] args) {

		// Exception Translation
//		try {
//		    ... // Use lower-level abstraction to do our bidding
//		} catch (LowerLevelException e) {
//		    throw new HigherLevelException(...);
//		}

	}
}
