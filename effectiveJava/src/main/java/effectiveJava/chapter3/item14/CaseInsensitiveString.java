package effectiveJava.chapter3.item14;

import java.util.Objects;

/**
 * 
 * 类 @code(CaseInsensitiveString)
 *
 * <p>功能简介：
 *
 * <p> 对象引用域的单个域Comparable
 *
 * <p>创建时间：2019年3月28日
 *
 * @author chenxj
 */
public final class CaseInsensitiveString implements Comparable<CaseInsensitiveString> { 
	
	private final String s;
	
	public CaseInsensitiveString(String s) {
		this.s = Objects.requireNonNull(s);
	}
	public int compareTo(CaseInsensitiveString cis) { 
		return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s); 
 } 

}