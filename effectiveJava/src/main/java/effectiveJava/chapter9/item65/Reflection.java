package effectiveJava.chapter9.item65;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

/**
 * 
 * 类 @code(Reflection)
 *
 * <p>
 * 功能简介：
 * <p>
 * 反射使用演示： 反射的合法(如果很少)用途是管理类对运行时可能不存在的其他类、方法或属性的依赖关系
 * 反射是一种功能强大的工具，对于某些复杂的系统编程任务是必需的，但是它有很多缺点。如果编写的程序必须在编译时处理未知的类，则应该尽可能只使用反射实例化对象，并使用在编译时已知的接口或父类访问对象。
 * <p>
 * 创建时间：2019年5月17日
 *
 * @author chenxj
 */
public class Reflection {
	// Reflective instantiation with interface access
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Translate the class name into a Class object
		Class<? extends Set<String>> cl = null;
		try {
			cl = (Class<? extends Set<String>>) // Unchecked cast!
			Class.forName(args[0]);
		} catch (ClassNotFoundException e) {
			fatalError("Class not found.");
		}
		// Get the constructor
		Constructor<? extends Set<String>> cons = null;
		try {
			cons = cl.getDeclaredConstructor();
		} catch (NoSuchMethodException e) {
			fatalError("No parameterless constructor");
		}

		// Instantiate the set
		Set<String> s = null;
		try {
			s = cons.newInstance();
		} catch (IllegalAccessException e) {
			fatalError("Constructor not accessible");
		} catch (InstantiationException e) {
			fatalError("Class not instantiable.");
		} catch (InvocationTargetException e) {
			fatalError("Constructor threw " + e.getCause());
		} catch (ClassCastException e) {
			fatalError("Class doesn't implement Set");
		}

		// Exercise the set
		s.addAll(Arrays.asList(args).subList(1, args.length));
		System.out.println(s);
	}

	private static void fatalError(String msg) {
		System.err.println(msg);
		System.exit(1);
	}
}
