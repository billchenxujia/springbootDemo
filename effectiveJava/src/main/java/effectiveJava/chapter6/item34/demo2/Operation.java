package effectiveJava.chapter6.item34.demo2;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * 类 @code(Operation)
 *
 * <p>
 * 功能简介：
 * <p>
 * 特定于常量的方法实现可以与特定于常量的数据结合使用。 例如，以下是Operation的一个版本，它重写toString方法以返回通常与该操作关联的符号：
 * <p>
 * 除了编译时常量属性（条目
 * 34）之外，枚举构造方法不允许访问枚举的静态属性。此限制是必需的，因为静态属性在枚举构造方法运行时尚未初始化。这种限制的一个特例是枚举常量不能从构造方法中相互访问
 * <p>
 * Java 8 中我们可以通过 `::` 关键字来访问类的构造方法，对象方法，静态方法。
 * JDK8中有双冒号的用法，就是把方法当做参数传到stream内部，使stream的每个元素都传入到该方法里面执行一下。
 * <p>
 * 创建时间：2019年4月12日
 *
 * @author chenxj
 */
public enum Operation {
	PLUS("+") {
		public double apply(double x, double y) {
			return x + y;
		}
	},
	MINUS("-") {
		public double apply(double x, double y) {
			return x - y;
		}
	},
	TIMES("*") {
		public double apply(double x, double y) {
			return x * y;
		}
	},
	DIVIDE("/") {
		public double apply(double x, double y) {
			return x / y;
		}
	};

	private final String symbol;

	// Implementing a fromString method on an enum type
	private static final Map<String, Operation> stringToEnum = Stream.of(values())
			.collect(Collectors.toMap(Object::toString, e -> e));

	// Returns Operation for string, if any
	public static Optional<Operation> fromString(String symbol) {
		return Optional.ofNullable(stringToEnum.get(symbol));
	}

	Operation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}

	// Switch on an enum to simulate a missing method
	/**
	 * 如果对枚举的switch语句不是实现常量特定行为的好选择，那么它们有什么好处呢?枚举类型的switch有利于用常量特定的行为增加枚举类型。例如，假设Operation枚举不在你的控制之下，你希望它有一个实例方法来返回每个相反的操作。你可以用以下静态方法模拟效果:
	 * 
	 * @param op
	 * @return
	 */
	public static Operation inverse(Operation op) {
		switch (op) {
		case PLUS:
			return Operation.MINUS;
		case MINUS:
			return Operation.PLUS;
		case TIMES:
			return Operation.DIVIDE;
		case DIVIDE:
			return Operation.TIMES;
		default:
			throw new AssertionError("Unknown op: " + op);
		}
	}

	public abstract double apply(double x, double y);

	// 为了演示方便才写的，一般程序入口只有最外层的顶层入口。
	public static void main(String[] args) {
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		for (Operation op : Operation.values())
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
	}
}
