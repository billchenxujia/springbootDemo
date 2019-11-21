package effectiveJava.chapter7.item45.demo2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

//Overuse of streams - don't do this!
/**
 * 
 * 类 @code(Anagrams)
 *
 * <p>
 * 功能简介：
 * <p>
 * 过度使用流式API,如果不能让代码变得清晰易懂，永远不要使用
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
			words.collect(groupingBy(word -> word.chars().sorted()
					.collect(StringBuilder::new, (sb, c) -> sb.append((char) c), StringBuilder::append).toString()))
					.values().stream().filter(group -> group.size() >= minGroupSize)
					.map(group -> group.size() + ": " + group).forEach(System.out::println);
		}
	}
}
