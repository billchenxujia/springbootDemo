package effectiveJava.chapter3.item10.demo2;

/**
 * 
 * 类 @code(PhoneNumber)
 *
 * <p>
 * 功能简介：
 *
 * <p>
 * 典型的equals重写展示
 * 
 * <p>
 * 综合前述，下面是一个高质量的equals方法的秘诀：
 * <p>
 * 1.使用==操作子检测参数是否是这个对象的一个引用。如果如此，返回真。 这只是一个性能优化，但是如果对比可能代价大时，这件事情是值得做的。
 * <p>
 * 2.使用instanceof操作子检查参数是否有相同的类型。如果没有，返回假。 通常，正确的类型是一个类，这个方法在这个类里面出现。有时，类型是这
 * 个类实现的某个接口。如果类实现了一个接口，这个接口改善了equals协定 ，允许实现该接口的类之间比较，那么使用接口。Collection接口，比如
 * Set、List、Map和Map.Entry，有这个属性。
 * <p>
 * 3.强转参数到正确的类型。因为这个强转之前有instanceof检测，保证了成功。
 * <p>
 * 4.在类里面的每个“重要”域，检测参数的域是否匹配这个对象的相应的域。 如果所有这些检测通过，返回真；否则，返回假。如果步骤2的类型是一个
 * 接口，你必须通过接口的方法获取参数的域；如果类型是类的话，你或许 可能直接获取域，决定于它们的可存取性。
 *
 * <p>
 * 创建时间：2019年3月25日
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
	/*@Override public int hashCode() { 
	    return Objects.hash(lineNum, prefix, areaCode); 
	}*/
}
