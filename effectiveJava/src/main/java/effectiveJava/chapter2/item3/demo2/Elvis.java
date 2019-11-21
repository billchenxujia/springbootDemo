package effectiveJava.chapter2.item3.demo2;

import java.util.function.Supplier;

/**
 * 
 * 类{@code Elvis}
 * 
 * <p>功能简介：
 * <p>单例模式演示：通过静态工厂方法实现
 * 类加载时确保只调用一次私有的构造器，客户端调用静态方法
 * 获取实例，但也同样存在反射调用构造器的风险，好处如下：
 *<p> 1.明确提供的是单例
 *<p> 2.简单
 *<p> 3.为你以后想要返回非单例提供了很高的灵活性
 *<p> 4.方便你以后如果需要，更改为泛型单例工厂模式
 *<p> 5.为supplier接口调用提供了方便参看main方法示例
 * 
 *<p> 注：为保证序列化传递对象，最后反序列化的单例，需为所有
 * 实例字段添加transient并提供下面所展示的readResolve方法
 * 
 * <p>创建时间：2019年3月23日
 * 
 * @author chenxj
 */
public class Elvis {
	
	private static final Elvis INSTANCE =new Elvis();
	private Elvis() {
		
	}
	
	public static Elvis getInstance() {
		return INSTANCE;
	}
	//readResolve method to preserve singleton property
	private Object readResolve() {
		return INSTANCE;
	}
	
	public void leaveTheBuilding() {
			
	}
	
	public static void main(String[] args) {
		Supplier<Elvis> supplier = Elvis::getInstance;
		System.out.println(supplier.get().getClass());
	}
	
}
