package effectiveJava.chapter3.item10.demo1;

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
	
	// 已破坏 - 违反了里氏代换原则
	//这段代码是试图通过getClass来维护equals协定，但是破坏了里氏代换原则
		/*@Override 
		public boolean equals(Object o) { 
		    if (o == null || o.getClass() != getClass()) 
		        return false; 
		        
		    Point p = (Point) o; 
		    return p.x == x && p.y == y; 
		}*/
}