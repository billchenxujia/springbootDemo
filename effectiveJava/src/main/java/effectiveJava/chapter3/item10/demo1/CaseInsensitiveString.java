package effectiveJava.chapter3.item10.demo1;

import java.util.Objects;

/**
 * 
 * 类 @code(CaseInsensitiveString)
 *
 * <p>
 * 功能简介：
 *
 * <p>
 * 重写equals方法违背对称性演示： 注：重写equals方法有五个必须遵守的原则如下：
 * <p>
 * 1.反身性 任何non-null,自己与自己对比返回必为ture这个好理解，没有示例
 * <p>
 * 2.对称性 任何non-null,x.equals(y)结果与y.equals(x)必须一致
 * <p>
 * 3.传递性 任何non-null,x.equals(y)==true,y.equals(z)==true,则x.equals(z)==true成立
 * <p>
 * 4.一致性 任何non-null,在传入参数未发生变化前，无论多少次调用都应保持一致性
 * <p>
 * 5.任何非null与null返回必须为false
 * 
 *
 * <p>
 * 创建时间：2019年3月24日
 *
 * @author chenxj
 */
public class CaseInsensitiveString {
	private final String s;

	public CaseInsensitiveString(String s) {
		this.s = Objects.requireNonNull(s);
	}

	// 已破坏 - 违反了对称性!·
	@Override
	public boolean equals(Object o) {
		if (o instanceof CaseInsensitiveString)
			return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
		if (o instanceof String) // 单方向可交互!
			return s.equalsIgnoreCase((String) o);
		return false;
//		return o instanceof CaseInsensitiveString && 
//		        ((CaseInsensitiveString) o).s.equalsIgnoreCase(s); 
		//正确的返回应该是上面那个，返回一个简单双向交互确保对称性
	}
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		CaseInsensitiveString cis = new CaseInsensitiveString("Polish"); 
		String s = "polish";
		System.out.println(cis.equals(s)==s.equals(cis));
		
	}
}
