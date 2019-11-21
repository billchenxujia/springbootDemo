package effectiveJava.chapter9.item60;

import java.math.BigDecimal;

/**
 * 
 * 类 @code(AvoidFloatAndDouble)
 *
 * <p>
 * 功能简介：
 * <p>
 * 精确计算避免使用Float/Double
 * 对于任何需要精确答案的计算，不要使用float或double。如果希望系统控制十进制小数点，并且不介意不使用基本类型带来的不便和成本，请使用BigDecimal。使用BigDecimal的另一个好处是，它可以完全控制舍入，当执行需要舍入的操作时，可以从八种舍入模式中进行选择。如果你使用合法的舍入行为执行业务计算，这将非常方便。如果性能是最重要的，那么不介意自己控制十进制小数点，而且数量不是太大，可以使用int或long。如果数量不超过9位小数，可以使用int;如果不超过18位，可以使用long。如果数量可能超过18位，则使用BigDecimal。
 * 
 * <p>
 * 创建时间：2019年5月16日
 *
 * @author chenxj
 */
public class AvoidFloatAndDouble {

	public static void main(String[] args) {
		calculateByDouble();
		calculateByBigDecimal();
		calculateByInt();
	}

	// Broken - uses floating point for monetary calculation!
	private static void calculateByDouble() {
		double funds = 1.00;
		int itemsBought = 0;
		for (double price = 0.10; funds >= price; price += 0.10) {
			funds -= price;
			itemsBought++;
		}
		System.out.println(itemsBought + " items bought.");
		System.out.println("Change: $" + funds);
	}

	private static void calculateByBigDecimal() {
		final BigDecimal TEN_CENTS = new BigDecimal(".10");
		int itemsBought = 0;
		BigDecimal funds = new BigDecimal("1.00");
		for (BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0; price = price.add(TEN_CENTS)) {
			funds = funds.subtract(price);
			itemsBought++;
		}
		System.out.println(itemsBought + " items bought.");
		System.out.println("Money left over: $" + funds);
	}
	
	private static void calculateByInt() {
		int itemsBought = 0;
	    int funds = 100;
	    for (int price = 10; funds >= price; price += 10) {
	        funds -= price;
	        itemsBought++;
	    }
	    System.out.println(itemsBought + " items bought.");
	    System.out.println("Cash left over: " + funds + " cents");
	}
}
