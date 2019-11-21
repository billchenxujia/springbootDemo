package effectiveJava.chapter11.item82;

/**
 * 
 * 类 @code(LazyInitializationImprove)
 *
 * <p>
 *  功能简介：
 * <p>
* 延迟加载使用示例
 * <p>
 *  创建时间：2019年6月12日
 *
 * @author chenxj
 */
public class LazyInitializationImprove {
	
	private static class FieldType{
		
	}
	
	// Double-check idiom for lazy initialization of instance fields
	private volatile FieldType field;

	@SuppressWarnings("unused")
	private FieldType getField() {
	    FieldType result = field;
	    if (result == null) {  // First check (no locking)
	        synchronized(this) {
	            if (field == null)  // Second check (with locking)
	                field = result = computeFieldValue();
	        }
	    }
	    return result;
	}
	
	//初始化示例方法，为了编译通过
	private FieldType computeFieldValue() {
		return null;
	}
}
