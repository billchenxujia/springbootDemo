package com.example.demo.comm;

/**
 * 
 * 类 @code(FinallyTest)
 *
 * <p>
 *  功能简介：
 * <p>
* finally执行验证
 * <p>
 *  创建时间：2019年8月21日
 *
 * @author chenxj
 */
public class FinallyTest {

	public static void main(String[] args) {
		try {
			Integer.valueOf("b1");
		} catch (Exception e) {
			System.out.println("转换异常");
			System.exit(0);
		} finally {
			System.out.println("程序结束");
		}

	}

}
