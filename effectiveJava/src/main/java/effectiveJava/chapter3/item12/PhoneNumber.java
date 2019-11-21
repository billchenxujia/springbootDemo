package effectiveJava.chapter3.item12;

/**
 * 
 * 类 @code(PhoneNumber)
 *
 * <p>
 * 功能简介：
 *
 * <p>
 * 重写toString方法演示：
 * <p>
 * 在实际使用时，toString方法应该返回包含在对象中的所有感兴趣的信息，就像在电话号码例子所示。如果一个对象很大，或者如果它包含状态不有助于字符串表示，这是不实际的。
 * <p>
 * 无论你是否指定格式，你应该清楚地文档化你的意图。如果你指定了这个格式，那么你应该精确地这么做。比如，下面是一个toString方法，与条目11的PhoneNumber类相配
 * <p>
 * 不管你是否指定格式，提供编程获取包含在toString返回值的信息
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

	/**
	 * * 返回电话号码的字符串表示。
	 * 
	 * 字符串包含十二个字符，它的格式是
	 * "/AAA-BBB-CCCC"， 这个格式中，AAA是地区码，BBB 是前缀，CCCC是线路号码。
	 * 每个大写字母代表单个十进制数字。
	 * 如果这个电话号码的三个部分的任何一个太小了，以致不能填满它的地方，这个地方开头填充零。
	 * 比如，如果线路号码的值是123，字符串表示的最后四个字符为0123。
	 */
	@Override
	public String toString() {
		return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
	}
}
