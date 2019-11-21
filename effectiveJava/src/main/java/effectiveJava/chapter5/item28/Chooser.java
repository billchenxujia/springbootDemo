package effectiveJava.chapter5.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * 类 @code(Chooser)
 *
 * <p>
 * 功能简介：
 * <p>
 * 基于列表的Chooser - 安全类型
 * <p>
 * 总之，数组和泛型有非常不同的类型规则。数组是协变的和具体化的；泛型是不变的和擦除的。结果是，数组提供了运行时类型安全而不是编译时类型安全，对于泛型反之。通常，数组和泛型混合的不好。如果你发现自己混合了它们，而且在编译时错误或者警告，你的第一反应应该是用列表替换数组
 * <p>
 * 创建时间：2019年4月9日
 *
 * @author chenxj
 */
public class Chooser<T> {
	private final List<T> choiceList;

	public Chooser(Collection<? extends T> choices) {
		choiceList = new ArrayList<>(choices);
	}

	public T choose() {
		Random rnd = ThreadLocalRandom.current();
		return choiceList.get(rnd.nextInt(choiceList.size()));
	}
}
