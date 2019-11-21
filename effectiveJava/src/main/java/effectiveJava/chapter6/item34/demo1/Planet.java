package effectiveJava.chapter6.item34.demo1;

/**
 * 
 * 类 @code(Planet)
 *
 * <p>
 * 功能简介：
 * <p>
 * 复杂枚举类演示
 * <p>
 * 要将数据与枚举常量相关联，请声明实例属性并编写一个构造方法，构造方法带有数据并将数据保存在属性中
 * <p>
 * 创建时间：2019年4月12日
 *
 * @author chenxj
 */
public enum Planet {
	MERCURY(3.302e+23, 2.439e6), VENUS(4.869e+24, 6.052e6), EARTH(5.975e+24, 6.378e6), MARS(6.419e+23, 3.393e6),
	JUPITER(1.899e+27, 7.149e7), SATURN(5.685e+26, 6.027e7), URANUS(8.683e+25, 2.556e7), NEPTUNE(1.024e+26, 2.477e7);

	private final double mass; // In kilograms
	private final double radius; // In meters
	private final double surfaceGravity; // In m / s^2
	// Universal gravitational constant in m^3 / kg s^2
	private static final double G = 6.67300E-11;

	// Constructor
	Planet(double mass, double radius) {
		this.mass = mass;
		this.radius = radius;
		surfaceGravity = G * mass / (radius * radius);
	}

	public double mass() {
		return mass;
	}

	public double radius() {
		return radius;
	}

	public double surfaceGravity() {
		return surfaceGravity;
	}

	public double surfaceWeight(double mass) {
		return mass * surfaceGravity; // F = ma
	}

}
