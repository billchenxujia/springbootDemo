package effectiveJava.chapter4.item17;

import java.math.BigInteger;

/**
 * 
 * 类 @code(Complex)
 *
 * <p>
 * 功能简介：
 *
 * <p>
 * 不可变复数类演示（尽可能使用不可变对象）
 * <p>
 * 不可变对象有与生俱来的线程安全性；它们不需要同步。多个线程并行地访问它们也不能损坏它们。这无疑是获得线程安全的最容易的方式。因为没有线程能观察到在一个不可变对象上的另外一个线程的影响，所有可以自由地分享不可变对象。所以不可变类应该鼓励客户端(只要有可能)复用已经存在的实例
 * <p>
 * 创建时间：2019年4月1日
 *
 * @author chenxj
 */
public final class Complex {

	public static final Complex ZERO = new Complex(0, 0);
	public static final Complex ONE = new Complex(1, 0);
	public static final Complex I = new Complex(0, 1);

	private final double re;
	private final double im;

	private Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	/**
	 * 它是最灵活的，因为它允许多个包私有实现类的使用。对于属于包外的它的客户端，不可变类是有效的final，因为一个类来自于另外一个包而且缺少公开或者受保护构造子，扩展它是不可能的。除了允许多个实现类的灵活性，而且通过增强静态工厂的对象缓冲能力，这个方法使得在后续的发布中对这个类进行性能调优是可能的
	 * 
	 * @param re
	 * @param im
	 * @return Complex实例
	 */
	public static Complex valueOf(double re, double im) {
		return new Complex(re, im);
	}

	public double realPart() {
		return re;
	}

	public double imaginaryPart() {
		return im;
	}

	public Complex plus(Complex c) {
		return new Complex(re + c.re, im + c.im);
	}

	public Complex minus(Complex c) {
		return new Complex(re - c.re, im - c.im);
	}

	public Complex times(Complex c) {
		return new Complex(re * c.re - im * c.im, re * c.im + im * c.re);
	}

	public Complex dividedBy(Complex c) {
		double tmp = c.re * c.re + c.im * c.im;
		return new Complex((re * c.re + im * c.im) / tmp, (im * c.re - re * c.im) / tmp);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Complex))
			return false;
		Complex c = (Complex) o;

		// 参考47页找出为什么使用compare而不是==
		return Double.compare(c.re, re) == 0 && Double.compare(c.im, im) == 0;
	}

	@Override
	public int hashCode() {
		return 31 * Double.hashCode(re) + Double.hashCode(im);
	}

	@Override
	public String toString() {
		return "(" + re + " + " + im + "i)";
	}

	/**
	 * 当编写BigInteger和BigDecimal时，不可变类不得不是有效的final，这在当初没有被广泛地理解，所以可以覆写它们的所有方法。不幸的是，为了保持向后兼容性这个事实，这不可能被改正。如果你编写一个类，它的安全性取决于BigInteger或者BigDecimal参数的不可变性，这参数来自不可信的客户端，那么你必须检查看一下这个参数是否是一个“真的”BigInteger或者BigDecimal，而不是不信任子类的一个实例。如果它是后者，基于假设它可能是可变的，你必须进行防御性拷贝
	 * 
	 * @param val
	 * @return
	 */
	public static BigInteger safeInstance(BigInteger val) {
		return val.getClass() == BigInteger.class ? val : new BigInteger(val.toByteArray());
	}
}
