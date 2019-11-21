package effectiveJava.chapter6.item34.demo1;

/**
 * 
 * 类 @code(Operation)
 *
 * <p>
 * 功能简介：
 * <p>
 * 在枚举类型中声明一个抽象的apply方法，并用常量特定的类主体中的每个常量的具体方法重写它。
 * 这种方法被称为特定于常量（constant-specific）的方法实现
 * <p>
 * 总之，枚举类型优于int常量的优点是令人信服的。 枚举更具可读性，更安全，更强大。
 * 许多枚举不需要显式构造方法或成员，但其他人则可以通过将数据与每个常量关联并提供行为受此数据影响的方法而受益。 使用单一方法关联多个行为可以减少枚举。
 * 在这种相对罕见的情况下，更喜欢使用常量特定的方法来枚举自己的值。 如果一些（但不是全部）枚举常量共享共同行为，请考虑策略枚举模式
 * <p>
 * 创建时间：2019年4月12日
 *
 * @author chenxj
 */
public enum Operation {
	PLUS {
		public double apply(double x, double y) {
			return x + y;
		}
	},
	MINUS {
		public double apply(double x, double y) {
			return x - y;
		}
	},
	TIMES {
		public double apply(double x, double y) {
			return x * y;
		}
	},
	DIVIDE {
		public double apply(double x, double y) {
			return x / y;
		}
	};

	public abstract double apply(double x, double y);
}