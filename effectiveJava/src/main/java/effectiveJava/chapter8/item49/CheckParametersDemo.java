package effectiveJava.chapter8.item49;

/**
 * 
 * 类 @code(CheckParametersDemo)
 *
 * <p>
 *  功能简介：
 * <p>
* 方法参数校验演示：
 * <p>
 *  创建时间：2019年5月5日
 *
 * @author chenxj
 */
public class CheckParametersDemo {
	
	// Private helper function for a recursive sort
	@SuppressWarnings("unused")
	private static void sort(long a[], int offset, int length) {
	    assert a != null;
	    assert offset >= 0 && offset <= a.length;
	    assert length >= 0 && length <= a.length - offset;
	    // Do the computation
	}
}
