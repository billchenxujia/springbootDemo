package effectiveJava.chapter9.item62;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * 类 @code(AvoidStrings)
 *
 * <p>
 * 功能简介：
 * <p>
 * 总而言之，当存在或可以编写更好的数据类型时，避免将对象表示为字符串的自然倾向。 使用不当，字符串比其他类型更麻烦，更灵活更差，速度更慢，更容易出错。
 * 字符串通常被滥用的类型包括基本类型，枚举类型和聚合类型。
 * <p>
 * 创建时间：2019年5月16日
 *
 * @author chenxj
 */
public class AvoidStrings {
	public static void main(String[] args) {
		String s = "bill_ss_bs_cd";
		String[] temps = s.split("_");
		List<String> lists = Arrays.asList(temps);
		System.out.println(lists.get(lists.size()-1));
		
	}
}
