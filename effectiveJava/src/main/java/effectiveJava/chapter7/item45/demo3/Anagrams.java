package effectiveJava.chapter7.item45.demo3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

/**
 * 
 * 类 @code(Anagrams)
 *
 * <p>
 * 功能简介：
 * <p>
 * Stream优雅使用示例：
 * <p>
 * 创建时间：2019年4月21日
 *
 * @author chenxj
 */
public class Anagrams {
	public static void main(String[] args) throws IOException {
		Path dictionary = Paths.get(args[0]);
		int minGroupSize = Integer.parseInt(args[1]);
		try (Stream<String> words = Files.lines(dictionary)) {
			words.collect(groupingBy(word -> alphabetize(word))).values().stream()
					.filter(group -> group.size() >= minGroupSize)
					.forEach(g -> System.out.println(g.size() + ": " + g));
		}
	}

	// alphabetize method is the same as in original version
	private static String alphabetize(String s) {
		char[] a = s.toCharArray();
		Arrays.sort(a);
		return new String(a);
	}
}
