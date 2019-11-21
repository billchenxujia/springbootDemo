package effectiveJava.chapter3.item10.demo2;

import java.util.Objects;

/**
 * 
 * 类 @code(ColorPoint)
 *
 * <p>功能简介：
 *
 * <p>通过组合来扩展Point，并保证了equals协定
 * 
 * <p>在Java平台库里有些类确实扩展一个不可实例化的类，而且添加了一个值类型。
 * 比如，java.sql.Timestamp扩展了java.util.Date，而且添加了nanoseconds域。
 * Timestamp的equals实现确实违反了对称性而且可能造成不稳定的行为，如果
 * Timestamp和Date对象在同一个数据集中或者另外的混用。只要你把它们分开，
 * 你就不会遇到麻烦，但是没有任何事情可以阻止你混用它们，而且造成的错误很难调试。
 * Timestamp类的行为是一个错误，不应该模仿。
 *
 *<p>注意，你可以添加值组件到抽象类的一个子类中，而没有违反equals协定。
 *这是重要的，对于根据在条目23(类层级优于标记类)的建议，你获取到这种类层级。
 *比如你可以有个没有值组件的抽象Shape类，Circle子类添加了一个radius域，
 *而且Rectangle子类添加了长和宽的域。只要不可能直接创建一个超类实例，前面
 *展示的这种问题不会发生。

 * <p>创建时间：2019年3月24日
 *
 * @author chenxj
 */
public class ColorPoint {
 private final Point point; 
 private final Color color;

 public ColorPoint(int x, int y, Color color) { 
     point = new Point(x, y); 
     this.color = Objects.requireNonNull(color);
 }

 /** 
   * 返回这个颜色点的Point的视图 
   */ 
 public Point asPoint() { 
     return point; 
 }

 @Override 
 public boolean equals(Object o) { 
     if (!(o instanceof ColorPoint)) 
         return false; 
     ColorPoint cp = (ColorPoint) o; 
     return cp.point.equals(point) && cp.color.equals(color); 
 }
 // 其余省略
}
