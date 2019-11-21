package effectiveJava.chapter2.item4;

/**
 * 
 * 类 @code(UtilityClass)
 *
 * <p>功能简介：
 *
 * <p>不可实例化的工具类展示：
 * 
 * <p>通过构造器权限私有化实现，确保无法实例化
 * 同时也意味着不能被继承
 *
 * <p>创建时间：2019年3月23日
 *
 * @author chenxj
 */
public class UtilityClass {
	//Suppress default constructor for noninstantiability
	private UtilityClass() {
		//断言异常，确保私有构造器永远不会调用
		throw new AssertionError();
	}
}
