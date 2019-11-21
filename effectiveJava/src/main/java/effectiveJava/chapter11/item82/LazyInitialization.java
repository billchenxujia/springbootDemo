package effectiveJava.chapter11.item82;

/**
 * 
 * 类 @code(LazyInitialization)
 *
 * <p>
 *  功能简介：
 * <p>
* 延迟加载使用示例
 * <p>
 *  创建时间：2019年6月11日
 *
 * @author chenxj
 */
public class LazyInitialization {
	
	private static class FieldType{
		
	}	
	// Lazy initialization of instance field - synchronized accessor
	private FieldType field;

	@SuppressWarnings("unused")
	private synchronized FieldType getField() {
	    if (field == null)
	        field = computeFieldValue();
	    return field;
	}
	
	// Lazy initialization holder class idiom for static fields
	private static class FieldHolder {
	    static final FieldType field = computeFieldValue();
	}

	@SuppressWarnings("unused")
	private static FieldType getFieldByHolder() { return FieldHolder.field; }
		
	//为编译通过示例方法
	private static FieldType computeFieldValue() {
		
		return null;
	}
	
	
}
