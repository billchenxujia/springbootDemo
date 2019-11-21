package effectiveJava.chapter7.item45.demo1;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

//Prints all large anagram groups in a dictionary iteratively
/**
 * 
 * 类 @code(Anagrams)
 *
 * <p>
 * 功能简介：
 * <p>
 * Stream API具有足够的通用性，实际上任何计算都可以使用Stream执行，但仅仅因为可以，并不意味着应该这样做。
 * 如果使用得当，流可以使程序更短更清晰；如果使用不当，它们会使程序难以阅读和维护。 
 * 对于何时使用流没有硬性的规则，但是有一些启发。
 * <p>
 * 创建时间：2019年4月21日
 *
 * @author chenxj
 */
public class Anagrams {
	public static void main(String[] args) throws IOException {
		File dictionary = new File(args[0]);
		int minGroupSize = Integer.parseInt(args[1]);
		Map<String, Set<String>> groups = new HashMap<>();
		try (Scanner s = new Scanner(dictionary)) {
			while (s.hasNext()) {
				String word = s.next();
				groups.computeIfAbsent(alphabetize(word), (unused) -> new TreeSet<>())
				.add(word);
			}
		}
		for (Set<String> group : groups.values())
			if (group.size() >= minGroupSize)
				System.out.println(group.size() + ": " + group);	
	}

	private static String alphabetize(String s) {
		char[] a = s.toCharArray();
		Arrays.sort(a);
		return new String(a);

	}

}