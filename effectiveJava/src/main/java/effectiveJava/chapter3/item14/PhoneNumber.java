package effectiveJava.chapter3.item14;

import java.util.Comparator;

/**
 * 
 * 类 @code(PhoneNumber)
 *
 * <p>
 * 功能简介：
 *
 * <p>
 *比较器常用接口演示
 * <p>
 *
 *
 * <p>
 * 创建时间：2019年3月26日
 *
 * @author chenxj
 */
public final class PhoneNumber {

	private final short areaCode, prefix, lineNum;

	// 已破坏 基于差的比较器 - 违反了传递性!
	/*
	 * static Comparator<Object> hashCodeOrder = new Comparator<>() { public int
	 * compare(Object o1, Object o2) { return o1.hashCode() - o2.hashCode(); } };
	 */

	// 基于静态compare方法的Comparator
	static Comparator<Object> hashCodeOrder = new Comparator<>() {
		public int compare(Object o1, Object o2) {
			return Integer.compare(o1.hashCode(), o2.hashCode());
		}
	};

	/*
	 * // 基于Comparator构建方法的Comparator static Comparator<Object> hashCodeOrder =
	 * Comparator.comparingInt(o -> o.hashCode());
	 */

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

	@Override
	public int hashCode() {
		int result = Short.hashCode(areaCode);
		result = 31 * result + Short.hashCode(prefix);
		result = 31 * result + Short.hashCode(lineNum);
		return result;
	}

	// 原始域的多域比较
	/*
	 * public int compareTo(PhoneNumber pn) { int result =
	 * Short.compare(areaCode,pn.areaCode); if (result == 0) { result =
	 * Short.compare(prefix, pn.prefix); if (result == 0) result =
	 * Short.compare(lineNum, pn.lineNum); } return result; }
	 */
	// 比较器构建方法的Comparable
	private static final Comparator<PhoneNumber> COMPARATOR = Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode)
			.thenComparingInt(pn -> pn.prefix).thenComparingInt(pn -> pn.lineNum);

	public int compareTo(PhoneNumber pn) {
		return COMPARATOR.compare(this, pn);
	}

	public static void main(String[] args) {

		PhoneNumber num1 = new PhoneNumber(111, 222, 3333);
		PhoneNumber num2 = new PhoneNumber(111, 444, 3333);
		System.out.println(num1.compareTo(num2));

	}

}
