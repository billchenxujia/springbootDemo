package effectiveJava.chapter9.item63;

/**
 * 
 * 类 @code(StringConcatenation)
 *
 * <p>
 *  功能简介：
 * <p>
* 道理很简单：除非性能无关紧要，否则不要使用字符串连接操作符组合多个字符串。而是使用StringBuilder的append方法。或者，使用字符数组，或者一次处理一个字符串，而不是把它们组合起来。
 * <p>
 *  创建时间：2019年5月16日
 *
 * @author chenxj
 */
public class StringConcatenation {
	
	private static final int LINE_WIDTH = 16;

	// Inappropriate use of string concatenation - Performs poorly!
	public String statement() {
	    String result = "";
	    for (int i = 0; i < numItems(); i++)
	        result += lineForItem(i);  // String concatenation
	    return result;
	}
	
	public String statementByStringBuilder() {
	    StringBuilder b = new StringBuilder(numItems() * LINE_WIDTH);
	    for (int i = 0; i < numItems(); i++)
	        b.append(lineForItem(i));
	    return b.toString();
	}
	private String lineForItem(int i) {
		
		return null;
	}

	private int numItems() {
		
		return 0;
	}
}
