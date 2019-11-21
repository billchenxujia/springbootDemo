package effectiveJava.chapter6.item34.demo1;

/**
 * 
 * 类 @code(WeightTable)
 *
 * <p>
 * 功能简介：
 * <p>
 * 以命令行方式运行向main方法注入参数
 * <p>
 * 创建时间：2019年4月12日
 *
 * @author chenxj
 */
public class WeightTable {
	public static void main(String[] args) {
		double earthWeight = Double.parseDouble(args[0]);
		double mass = earthWeight / Planet.EARTH.surfaceGravity();
		for (Planet p : Planet.values())
			System.out.printf("Weight on %s is %f%n", p, p.surfaceWeight(mass));
	}
}
