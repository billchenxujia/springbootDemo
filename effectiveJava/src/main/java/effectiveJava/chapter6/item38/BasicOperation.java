package effectiveJava.chapter6.item38;

/**
 * 
 * 类 @code(BasicOperation)
 *
 * <p>
 * 功能简介：
 * <p>
 * 实现接口扩展基本的操作方法演示：
 * <p>
 * 创建时间：2019年4月15日
 *
 * @author chenxj
 */
public enum BasicOperation implements Operation {
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

	BasicOperation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}
}
