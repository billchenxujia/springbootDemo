package effectiveJava.chapter2.item5;

import java.util.List;
import java.util.Objects;

/**
 * 
 * 类 @code(SpellChecker)
 *
 * <p>功能简介：
 *
 * <p>依赖注入演示：通过构造器直接传入依赖对象
 *
 * <p>创建时间：2019年3月23日
 *
 * @author chenxj
 */
public class SpellChecker {
	
	@SuppressWarnings("unused")
	private final Lexicon dictionary;
	
	public SpellChecker(Lexicon dictionary) {
		this.dictionary = Objects.requireNonNull(dictionary);
	}
	
	public boolean isValid(String word) {
		//演示代码
		return true;
	}
	
	public List<String> suggestions(String typo){
		//演示代码
		return null;
	}

}
