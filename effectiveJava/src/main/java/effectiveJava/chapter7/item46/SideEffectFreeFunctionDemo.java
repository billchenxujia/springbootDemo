package effectiveJava.chapter7.item46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

/**
 * 
 * 类 @code(SideEffectFreeFunctionDemo)
 *
 * <p>
 * 功能简介：
 * <p>
 * 无副作用流使用演示：
 * <p>
 * 创建时间：2019年4月24日
 *
 * @author chenxj
 */
public class SideEffectFreeFunctionDemo {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		demo1(file);
		demo2(file);
		demo3();
	}

	private static void demo1(File file) throws FileNotFoundException {
		// Uses the streams API but not the paradigm--Don't do this!
		Map<String, Long> freq = new HashMap<>();
		try (@SuppressWarnings("resource")
		Stream<String> words = new Scanner(file).tokens()) {
			words.forEach(word -> {
				freq.merge(word.toLowerCase(), 1L, Long::sum);
			});
		}
		System.out.println(freq);
	}

	private static void demo2(File file) throws FileNotFoundException {
		// Proper use of streams to initialize a frequency table		
		Map<String, Long> freq;
		try (@SuppressWarnings("resource")
		Stream<String> words = new Scanner(file).tokens()) {
			freq = words.collect(groupingBy(String::toLowerCase, counting()));
		}
		System.out.println(freq);
	}

	private static void demo3() {
		// Pipeline to get a top-ten list of words from a frequency table
		Map<String, Long> freq = new HashMap<>();
		@SuppressWarnings("unused")
		List<String> topTen = freq.keySet().stream().sorted(comparing(freq::get).reversed()).limit(10)
				.collect(toList());
		System.out.println(freq);
	}
}
