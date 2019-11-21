package effectiveJava.chapter2.item3.demo3;

/**
 *
 * 类{@code Elvis}
 * 
 * <p>功能简介:
 * 
 * <p>单例模式演示,通过单元素枚举实现
 * 默认体提供序列化单例保障，避免反射，序列化攻击。
 * 但是如果需要继承非Enum进行扩展不能使用，除此情
 * 景下单例的最佳实现方式
 * 
 * <p>创建时间：2019年3月23日
 * 
 *  @author chenxj
 * 
 */
public enum Elvis {
	INSTANCE;
	
	public void leaveTheBuilding() {
		
	}
}
