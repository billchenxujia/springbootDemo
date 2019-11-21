package effectiveJava.chapter6.item38;

/**
 * 
 * 类 @code(OperationTest)
 *
 * <p>
 * 功能简介：
 * <p>
 * 遍历使用整个扩展操作演示
 * 总之，虽然不能编写可扩展的枚举类型，但是你可以编写一个接口来配合实现接口的基本的枚举类型，来对它进行模拟。这允许客户端编写自己的枚举（或其它类型）来实现接口。如果API是根据接口编写的，那么在任何使用基本枚举类型实例的地方，都可以使用这些枚举类型实例
 * <p>
 * 创建时间：2019年4月15日
 *
 * @author chenxj
 */
public class OperationByGenericDeclare {
	public static void main(String[] args) {
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		test(ExtendedOperation.class, x, y);
	}
	
	/**
	 * 泛型方法实现对传入的enum遍历，并调用apply
	 * 
	 * @param <T>        泛型化声明并并确保是enum以及实现了Operation
	 * @param opEnumType 传入的class类对象（受声明的约束）
	 * @param x          double操作数x
	 * @param y          double操作数y
	 */
	private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y) {
		for (Operation op : opEnumType.getEnumConstants())
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
	}
}
