package effectiveJava.chapter6.item40;

import java.util.HashSet;
import java.util.Set;

//Can you spot the bug?
/**
 * 
 * 类 @code(Bigram)
 *
 * <p>
 * 功能简介：
 * <p>
 * 总之，如果在每个方法声明中使用Override注解，并且认为要重写父类声明，那么编译器可以保护免受很多错误的影响，但有一个例外。
 * 在具体的类中，不需要注解标记你确信可以重写抽象方法声明的方法（尽管这样做也没有坏处）。
 * <p>
 * 创建时间：2019年4月16日
 *
 * @author chenxj
 */
public class Bigram {
	private final char first;
	private final char second;

	public Bigram(char first, char second) {
		this.first = first;
		this.second = second;
	}

	/*
	 * @Override public boolean equals(Bigram b) { return b.first == first &&
	 * b.second == second; }加上@Override在你认为需要重写的方法上确保了不犯这种低级错误
	 */
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Bigram))
			return false;
		Bigram b = (Bigram) o;
		return b.first == first && b.second == second;
	}

	@Override
	public int hashCode() {
		return 31 * first + second;
	}

	public static void main(String[] args) {
		Set<Bigram> s = new HashSet<>();
		for (int i = 0; i < 10; i++)
			for (char ch = 'a'; ch <= 'z'; ch++)
				s.add(new Bigram(ch, ch));
		System.out.println(s.size());
	}

}
