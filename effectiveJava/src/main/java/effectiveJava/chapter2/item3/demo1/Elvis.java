package effectiveJava.chapter2.item3.demo1;

/**
 * 
 * 类{@code Elvis}
 * 
 * <p>功能简介：
 * 
 * <p>单例模式演示：通过公共的final属性实现
 * 类加载时确保只调用一次私有的构造器，唯一的风险是有特殊权限的
 * 客户端类通过反射来调用私有构造器，可通过修改构造器当被第二次
 * 调用时直接抛出异常来避免
 * 
 * <p>创建时间：2019年3月23日
 * 
 * @author chenxj
 */
public class Elvis {
	
	public static final Elvis INSTANTCE = new Elvis();
	private Elvis() {
		
	}
	
	public void leaveTheBuilding() {
		
	}
}
