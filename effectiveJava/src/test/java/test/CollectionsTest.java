package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 
 * 类 @code(CollectionsTest)
 *
 * <p>
 *  功能简介：
 * <p>
* 集合测试列
 * <p>
 *  创建时间：2019年5月4日
 *
 * @author chenxj
 */
public class CollectionsTest {
	public static void main(String[] args) {
		Set<String> srcSet = new HashSet<>();
		srcSet.add("chen");
		srcSet.add("chen");
		srcSet.add("bill");
		srcSet.add("hello");
		List<String> src = new ArrayList<>(srcSet);
		String first = src.get(2);
		System.out.println(src);
		System.out.println(first);
	}
}
