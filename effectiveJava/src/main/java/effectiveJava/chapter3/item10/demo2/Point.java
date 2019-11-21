package effectiveJava.chapter3.item10.demo2;

/**
 * 
 * 类 @code(Point)
 *
 * <p>功能简介：
 *
 * <p>重写equals对称性，演示
 *
 * <p>创建时间：2019年3月24日
 *
 * @author chenxj
 */
public class Point {
	private final int x;
	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Point))
			return false;
		Point p = (Point) o;
		return p.x == x && p.y == y;
	}
}