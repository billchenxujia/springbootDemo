package effectiveJava.chapter6.item37.demo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static java.util.stream.Collectors.*;

/**
 * 
 * 类 @code(Plant)
 *
 * <p>
 * 功能简介：
 * <p>
 * EnumMap使用演示类
 * 简单的类来代表一种植物
 * <p>
 * 创建时间：2019年4月14日
 *
 * @author chenxj
 */
class Plant {
	enum LifeCycle {
		ANNUAL, PERENNIAL, BIENNIAL
	}

	final String name;
	final LifeCycle lifeCycle;

	Plant(String name, LifeCycle lifeCycle) {
		this.name = name;
		this.lifeCycle = lifeCycle;
	}

	@Override
	public String toString() {
		return name;
	}

	public static void main(String[] args) {

		List<Plant> gardenList = new ArrayList<>();// 模拟构造花园，实际应该有很多植物add进去，简化没写
		Plant[] garden = (Plant[]) gardenList.toArray();
		// Using ordinal() to index into an array - DON'T DO THIS!
		/*
		 * @SuppressWarnings("unchecked")//演示所用永远不要使用这个方法来放置 Set<Plant>[]
		 * plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
		 * for (int i = 0; i < plantsByLifeCycle.length; i++) plantsByLifeCycle[i] = new
		 * HashSet<>(); for (Plant p : garden)
		 * plantsByLifeCycle[p.lifeCycle.ordinal()].add(p); // Print the results for
		 * (int i = 0; i < plantsByLifeCycle.length; i++) {
		 * System.out.printf("%s: %s%n", Plant.LifeCycle.values()[i],
		 * plantsByLifeCycle[i]);
		 * 
		 * }
		 */

		// Using an EnumMap to associate data with an enum
		/**
		 * 这段程序更简短，更清晰，更安全，运行速度与原始版本相当。 没有不安全的转换; 无需手动标记输出，因为map键是知道如何将自己转换为可打印字符串的枚举;
		 * 并且不可能在计算数组索引时出错。
		 * EnumMap与序数索引数组的速度相当，其原因是EnumMap内部使用了这样一个数组，但它对程序员的隐藏了这个实现细节，将Map的丰富性和类型安全性与数组的速度相结合。
		 * 请注意，EnumMap构造方法接受键类型的Class对象：这是一个有限定的类型令牌（bounded type
		 * token），它提供运行时的泛型类型信息（条目 33）
		 */
		Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
		for (Plant.LifeCycle lc : Plant.LifeCycle.values())
			plantsByLifeCycle.put(lc, new HashSet<>());
		for (Plant p : garden)
			plantsByLifeCycle.get(p.lifeCycle).add(p);
		System.out.println(plantsByLifeCycle);

		// Naive stream-based approach - unlikely to produce an EnumMap!
		/**
		 * 基于stream版本的行为与EmumMap版本的行为略有不同。
		 * EnumMap版本总是为每个工厂生命周期生成一个嵌套map类，而如果花园包含一个或多个具有该生命周期的植物时，则基于流的版本才会生成嵌套map类。
		 * 因此，例如，如果花园包含一年生和多年生植物但没有两年生的植物，plantByLifeCycle的大小在EnumMap版本中为三个，在两个基于流的版本中为两个
		 */
		System.out.println(Arrays.stream(garden)
				.collect(groupingBy(p -> p.lifeCycle, () -> new EnumMap<>(LifeCycle.class), toSet())));
	}
}
