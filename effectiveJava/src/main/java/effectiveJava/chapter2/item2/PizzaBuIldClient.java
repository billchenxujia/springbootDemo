package effectiveJava.chapter2.item2;

import effectiveJava.chapter2.item2.NyPizza.Size;
import effectiveJava.chapter2.item2.Pizza.Topping;

/**
 * 
 * 类 @code(PizzaBuIldClient)
 *
 * <p>功能简介：
 *
 * <p>建造者模式客户端调用演示：
 * 
 * <p>通过建造者模式确保了客户端链式调用，保证了代码的可读性、简洁性
 *
 * <p>创建时间：2019年3月23日
 *
 * @author chenxj
 */
public class PizzaBuIldClient {

	public static void main(String[] args) {

		NyPizza pizza = new NyPizza.Builder(Size.SMALL).addTopping(Topping.SAUSAGE).addTopping(Topping.ONION).build();
		Calzone calzone = new Calzone.Builder().addTopping(Topping.HAM).sauceInside().build();
		System.out.println(pizza);
		System.out.println(calzone);
	}

}
