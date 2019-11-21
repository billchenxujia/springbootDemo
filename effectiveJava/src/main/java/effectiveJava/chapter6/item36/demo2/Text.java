package effectiveJava.chapter6.item36.demo2;

import java.util.Set;

//EnumSet - a modern replacement for bit fields
/**
 * 
 * 类 @code(Text)
 *
 * <p>
 * 功能简介：
 * <p>
 * 下面是前一个使用枚举和枚举集合替代位属性的示例。 它更短，更清晰，更安全
 * <p>
 * 总之，仅仅因为枚举类型将被用于集合中，所以没有理由用位属性来表示它。 EnumSet类将位属性的简洁性和性能与条目
 * 34中所述的枚举类型的所有优点相结合。EnumSet的一个真正缺点是，它不像Java
 * 9那样创建一个不可变的EnumSet，但是在即将发布的版本中可能会得到补救。
 * 同时，你可以用Collections.unmodifiableSet封装一个EnumSet，但是简洁性和性能会受到影响
 * <p>
 * 创建时间：2019年4月14日
 *
 * @author chenxj
 */
public class Text {
	public enum Style {
		BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
	}

	// Any Set could be passed in, but EnumSet is clearly best
	public void applyStyles(Set<Style> styles) {
	}
}