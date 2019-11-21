package effectiveJava.chapter4.item16;

/**
 * 
 * 类 @code(Point)
 *
 * <p>
 * 功能简介：
 *
 * <p>
 * public类中使用访问方法（get）演示
 * <p>
 * public类中公开域，意味着你放弃了封装的好处 会导致，你丧失灵活性，以及造成不必要的风险。因此 需应该使用访问方法来替代。
 * <p>
 * 如果一个类是包私有的或者是私有嵌套类，那么暴露它的数据域本质上没有什么错误--假设它们能够充分描述由类提供的抽象。相对于访问子方法，这个方法在类声明中和在使用它的客户端代码中有更少的视觉混乱。虽然客户端代码捆绑于类的内部表示，但是这个代码是限制在包含这个类的包中。如果表示中的改变变得迫切，那么你可以执行这个改变，而没有触碰到包外的任何代码。对于私有内嵌类这个情形，这个改变的范围进一步地限制在包含类中
 *
 * <p>
 * 创建时间：2019年4月1日
 *
 * @author chenxj
 */
class Point {
	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
}