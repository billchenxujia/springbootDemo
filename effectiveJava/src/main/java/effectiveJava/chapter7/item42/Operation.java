package effectiveJava.chapter7.item42;

import java.util.function.DoubleBinaryOperator;

/**
 * 
 * 类 @code(Operation)
 *
 * <p>
 *  功能简介：
 * <p>
* 使用lambda表达式使得枚举关联方法更加简洁
 * <p>
 *  创建时间：2019年4月16日
 *
 * @author chenxj
 */
public enum Operation {
	PLUS("+", (x, y) -> x + y),
	MINUS("-", (x, y) -> x - y),
	TIMES("*", (x, y) -> x * y),
	DIVIDE("/", (x, y) -> x / y);

	private final String symbol;
	
	private final DoubleBinaryOperator op;

	Operation(String symbol, DoubleBinaryOperator op) {
		this.symbol = symbol;
		this.op = op;
	}

	@Override
	public String toString() {
		return symbol;
	}

	public double apply(double x, double y) {
		return op.applyAsDouble(x, y);

	}

}
