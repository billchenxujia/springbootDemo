package test;

/**
 * 
 * 类 @code(ByteOperateTest)
 *
 * <p>
 * 功能简介：
 * <p>
 * 位移运算演示： 对于计算机, 加减乘数已经是最基础的运算, 要设计的尽量简单. 计算机辨别"符号位"显然会让计算机的基础电路设计变得十分复杂!
 * 于是人们想出了将符号位也参与运算的方法. 我们知道, 根据运算法则减去一个正数等于加上一个负数, 即: 1-1 = 1 + (-1) = 0 ,
 * 所以机器可以只有加法而没有减法, 这样计算机运算的设计就更简单了.
 * <p>
 * 创建时间：2019年4月30日
 *
 * @author chenxj
 */
public class ByteOperateTest {
	public static void main(String[] args) {
		var r = -20 >>> 2;
		System.out.println(r);
		var a = 1 << 8;
		System.out.println(a);		
		var index = 7 & 1;
		System.out.println(index);
		System.out.println(1<<4);
	}
}
