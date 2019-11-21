package effectiveJava.chapter6.item37.demo1;

//Using ordinal() to index array of arrays - DON'T DO THIS!
/**
 * 
 * 类 @code(Phase)
 *
 * <p>
 * 功能简介：
 * <p>
 * 这段程序可以运行，甚至可能显得优雅，但外观可能是骗人的。 就像前面显示的简单的花园示例一样，编译器无法知道序数和数组索引之间的关系。
 * 如果在转换表中出错或者在修改Phase或Phase.Transition枚举类型时忘记更新它，则程序在运行时将失败。
 * 失败可能是ArrayIndexOutOfBoundsException，NullPointerException或（更糟糕的）沉默无提示的错误行为。
 * 即使非空条目的数量较小，表格的大小也是phase的个数的平方
 * 
 * <p>
 * 创建时间：2019年4月14日
 *
 * @author chenxj
 */
public enum Phase {
	SOLID, LIQUID, GAS;

	public enum Transition {
		MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

		// Rows indexed by from-ordinal, cols by to-ordinal
		private static final Transition[][] TRANSITIONS = { { null, MELT, SUBLIME }, { FREEZE, null, BOIL },
				{ DEPOSIT, CONDENSE, null } };

		// Returns the phase transition from one phase to another
		public static Transition from(Phase from, Phase to) {
			return TRANSITIONS[from.ordinal()][to.ordinal()];

		}

	}

}
