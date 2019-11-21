package effectiveJava.chapter3.item11;

/**
 * 
 * 类 @code(PhoneNumber)
 *
 * <p>
 * 功能简介：
 *
 * <p>
 * 重写hashCode方法演示：
 * <p>
 * 重写equals后必须重写hashCode
 * <p>
 * <p>1.在应用执行期间，当在一个对象上反复调用hashCode方法时，它必须一致返回同样的值，假设equals比较中使用的信息没有改变。当一个应用的执行到另外一个应用，这个值没必要保持一致。
 * <p>2.根据equals(Object)方法，如果两个对象是相等，那么在这两个对象上调用hashCode必须产生同一个整数结果。
 * <p>3.根据equals(Object)方法，如果两个对象是不相等的，那么没有要求在每个对象调用hashCode必须产生不同的结果。然而，程序员应该明白，为不相等的对象产生不同的结果会可能改善哈希表的性能。
 *
 * <p>
 * 创建时间：2019年3月26日
 *
 * @author chenxj
 */
public final class PhoneNumber {
	private final short areaCode, prefix, lineNum;

	public PhoneNumber(int areaCode, int prefix, int lineNum) {
		this.areaCode = rangeCheck(areaCode, 999, "area code");
		this.prefix = rangeCheck(prefix, 999, "prefix");
		this.lineNum = rangeCheck(lineNum, 9999, "line num");
	}

	private static short rangeCheck(int val, int max, String arg) {
		if (val < 0 || val > max)
			throw new IllegalArgumentException(arg + ": " + val);
		return (short) val;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof PhoneNumber))
			return false;
		PhoneNumber pn = (PhoneNumber) o;
		return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
	}

	// 典型的hashCode方法
	@Override
	public int hashCode() {
		int result = Short.hashCode(areaCode);
		result = 31 * result + Short.hashCode(prefix);
		result = 31 * result + Short.hashCode(lineNum);
		return result;
	}
	// 只有一行hashCode方法 - 一般性能
	/*
	 * @Override public int hashCode() { return Objects.hash(lineNum, prefix,
	 * areaCode); }
	 */
}
