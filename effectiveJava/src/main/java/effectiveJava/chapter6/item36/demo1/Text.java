package effectiveJava.chapter6.item36.demo1;

//Bit field enumeration constants - OBSOLETE!
/**
 * 
 * 类 @code(Text)
 *
 * <p>
 * 功能简介：
 * <p>
 *  java.util包提供了EnumSet类来有效地表示从单个枚举类型中提取的值集合。
 * 这个类实现了Set接口，提供了所有其他Set实现的丰富性，类型安全性和互操作性。 但是在内部，每个EnumSet都表示为一个位矢量（bit
 * vector）。 如果底层的枚举类型有64个或更少的元素，并且大多数情况下，整个EnumSet用单个long表示，所以它的性能与位属性的性能相当。
 * 批量操作（如removeAll和retainAll）是使用按位算术实现的，就像你为位属性手动操作一样。
 * 但是完全避免了手动位混乱的丑陋和错误倾向：EnumSet为你做了很大的努力
 * 
 * <p>
 * 创建时间：2019年4月14日
 *
 * @author chenxj
 */
public class Text {
	public static final int STYLE_BOLD = 1 << 0; // 1
	public static final int STYLE_ITALIC = 1 << 1; // 2
	public static final int STYLE_UNDERLINE = 1 << 2; // 4
	public static final int STYLE_STRIKETHROUGH = 1 << 3; // 8

	// Parameter is bitwise OR of zero or more STYLE_ constants
	public void applyStyles(int styles) {
	}
}
