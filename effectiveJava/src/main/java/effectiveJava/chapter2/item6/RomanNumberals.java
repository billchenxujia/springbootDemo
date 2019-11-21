package effectiveJava.chapter2.item6;

import java.util.regex.Pattern;

/**
 * 
 * 类 @code(RomanNumberals)
 *
 * <p>功能简介：
 *
 * <p>复用对象演示
 * 
 * <p>通过服用对象提升程序的表现，
 * {@code Pattern对象创建开销巨大}如果每次正则对比都创建会严重
 * 影响程序运行，而且代码可读性也差，通过给其名字，大大提升了可
 * 读性，而且也保证了该对象的复用
 * <p>注：直接使用字符串的match，会导致每次调用匹配创建新的{@code Pattern}
 * 对象，因此不推荐使用
 *
 * <p>创建时间：2019年3月23日
 *
 * @author chenxj
 */
public class RomanNumberals {
	private static final Pattern ROMAN = Pattern
			.compile("^(?=.)M*(C[MD]|D?C{0,3})" + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

	static boolean isRomanNumeral(String s) {
		return ROMAN.matcher(s).matches();
	}
	
	/**
	 * <p>功能概述：
	 * <p>首选基本类型，使用包装类在此场景下产生一大堆垃圾对象
	 * @return 所有int值的和
	 */
	@SuppressWarnings("unused")
	private static long sum() {
		Long sum = 0L;
		for(long i = 0; i<=Integer.MIN_VALUE; i++) {
			sum += i;
		}			
		return sum;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		String s = new String("bikini");//永远不要这样做，这只会导致产生一堆垃圾String对象
	}
}
