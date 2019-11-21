package effectiveJava.chapter8.item50;

import java.util.Date;

/**
 * 
 * 类 @code(Period)
 *
 * <p>
 * 功能简介：
 * <p>
 * 防御性拷贝演示： 通过防御性拷贝防止了类的不变性被破坏
 * 总之，如果一个类有从它的客户端获取或返回的可变组件，那么这个类必须防御性地拷贝这些组件。如果拷贝的成本太高，并且类信任它的客户端不会不适当地修改组件，则可以用文档替换防御性拷贝，该文档概述了客户端不得修改受影响组件的责任
 * <p>
 * 创建时间：2019年5月6日
 *
 * @author chenxj
 */
//Broken "immutable" time period class
public final class Period {
	private final Date start;
	private final Date end;

	/**
	 * @param start the beginning of the period
	 * 
	 * @param end   the end of the period; must not precede start
	 * 
	 * @throws IllegalArgumentException if start is after end
	 * 
	 * @throws NullPointerException     if start or end is null
	 */
	/*
	 * public Period(Date start, Date end) { if (start.compareTo(end) > 0) throw new
	 * IllegalArgumentException(start + " after " + end); this.start = start;
	 * this.end = end; }
	 */
	// Repaired constructor - makes defensive copies of parameters
	public Period(Date start, Date end) {
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		if (this.start.compareTo(this.end) > 0)
			throw new IllegalArgumentException(this.start + " after " + this.end);
	}

	/*
	 * public Date start() { return start; }
	 * 
	 * public Date end() { return end; }
	 */
	// Repaired accessors - make defensive copies of internal fields
	public Date start() {
		return new Date(start.getTime());
	}

	public Date end() {
		return new Date(end.getTime());
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// Attack the internals of a Period instance
		Date start = new Date();
		Date end = new Date();
		@SuppressWarnings("unused")
		Period p = new Period(start, end);
		end.setYear(78); // Modifies internals of p!
	}
}
