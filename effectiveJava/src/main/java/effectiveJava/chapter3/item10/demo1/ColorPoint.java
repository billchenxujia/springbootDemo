package effectiveJava.chapter3.item10.demo1;

/**
 * 
 * 类 @code(ColorPoint)
 *
 * <p>功能简介：
 *
 * <p>继承点后重写equals难以保证遵守equals协定
 * 因此推荐，尽可能避免直接继承，并扩展一个值属性，那会导致最终难以满足equals传递性，对称性
 * 推荐的是使用组合，不通过继承，持有该成员变量，并通过新增其他成员来完成扩展，那样会确保equals
 * 协定不被违反
 *
 * <p>创建时间：2019年3月24日
 *
 * @author chenxj
 */
public class ColorPoint extends Point {
	
	private Color color;
	public ColorPoint(int x, int y, Color color) {
		super(x, y);
		this.color = color;		
	}
	// 已破坏 - 违反对称性!
	@Override
	public boolean equals(Object o) {
	    if (!(o instanceof ColorPoint))
	        return false;
	    return super.equals(o) && ((ColorPoint) o).color == color; 
	}
	// 已破坏 - 违反传递性! 而且存在同样的子类重写会导致无限递归
	/*@Override 
	public boolean equals(Object o) {
	    if (!(o instanceof Point))
	        return false;

	    // 如果o是个通常的Point，进行无关颜色的比较 
	    if (!(o instanceof ColorPoint)) 
	        return o.equals(this);

	    // o是ColorPoint类型; 进行全面的比较 
	    return super.equals(o) && ((ColorPoint) o).color == color;
	}*/
	
		
	public static void main(String[] args) {
		
		ColorPoint p1 = new ColorPoint(1, 2, Color.RED); 
		Point p2 = new Point(1, 2); 
		ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);		
		System.out.println(p1.equals(p2)||p2.equals(p3));
		
	}
	
}
