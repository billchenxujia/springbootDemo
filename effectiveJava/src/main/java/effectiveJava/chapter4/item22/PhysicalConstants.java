package effectiveJava.chapter4.item22;

/**
 * 常量效用类 
 * 类 @code(PhysicalConstants)
 *
 * <p>功能简介：
 *
 * <p>常量效用类 (避免使用接口常量类)
 *
 * <p>创建时间：2019年4月3日
 *
 * @author chenxj
 */
public class PhysicalConstants { 
 private PhysicalConstants() { }// 防止实例化

 public static final double AVOGADROS_NUMBER = 6.022_140_857e23; 
 public static final double BOLTZMANN_CONST = 1.380_648_52e-23; 
 public static final double ELECTRON_MASS = 9.109_383_56e-31;

}
