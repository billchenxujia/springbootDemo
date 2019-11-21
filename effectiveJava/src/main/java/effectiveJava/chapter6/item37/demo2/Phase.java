package effectiveJava.chapter6.item37.demo2;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

import java.util.EnumMap;

//Using a nested EnumMap to associate data with enum pairs
/**
 * 
 * 类 @code(Phase)
 *
 * <p>
 * 功能简介：
 * <p>
 * 使用EnumMap表明不同状态转换的演示
 * <p>
 * 创建时间：2019年4月14日
 *
 * @author chenxj
 */
public enum Phase {

	SOLID, LIQUID, GAS;

	public enum Transition {
		MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
		BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
		SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);
		private final Phase from;
		private final Phase to;
		
		Transition(Phase from, Phase to) {
			this.from = from;
			this.to = to;
		}

		// Initialize the phase transition map
		private static final Map<Phase, Map<Phase, Transition>> m = Stream.of(values())
				.collect(groupingBy(t -> t.from, () -> new EnumMap<>(Phase.class),
						toMap(t -> t.to, t -> t, (x, y) -> y, () -> new EnumMap<>(Phase.class))));

		public static Transition from(Phase from, Phase to) {
			return m.get(from).get(to);
		}

	}

}
