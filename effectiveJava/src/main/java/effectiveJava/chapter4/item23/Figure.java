package effectiveJava.chapter4.item23;

/**
 * 
 * 类 @code(Figure)
 *
 * <p>
 * 功能简介：
 *
 * <p>
 * 类层级演示：
 * <p>
 * 需要注意的是，上面层级中的域是直接访问的，而不是通过访问器方法。这是为了简单起见，如果层级是公开的，那么应该是一个糟糕的设计
 * <p>
 * 标签类很少是适合的。如果你倾向于编写有明显标签域的类，那么考虑这个标签是否移除，而且这个类是否可以用层级替代。当你遇见一个已经存在的带有标签域的类，考虑把它重构为一个层级
 * <p>
 * 创建时间：2019年4月3日
 *
 * @author chenxj
 */
abstract class Figure {
	abstract double area();
}
