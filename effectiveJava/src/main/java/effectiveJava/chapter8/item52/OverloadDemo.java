package effectiveJava.chapter8.item52;

/**
 * 
 * 类 @code(OverloadDemo)
 *
 * <p>
 * 功能简介：
 * <p>
 * 总而言之，仅仅可以重载方法并不意味着应该这样做。通常，最好避免重载具有相同数量参数的多个签名的方法。在某些情况下，特别是涉及构造方法的情况下，可能无法遵循此建议。在这些情况下，至少应该避免通过添加强制转换将相同的参数集传递给不同的重载。如果这是无法避免的，例如，因为要对现有类进行改造以实现新接口，那么应该确保在传递相同的参数时，所有重载的行为都是相同的。如果做不到这一点，程序员将很难有效地使用重载方法或构造方法，也无法理解为什么它不能工作
 * <p>
 * 创建时间：2019年5月8日
 *
 * @author chenxj
 */
public class OverloadDemo {

	public static void main(String[] args) {
		new Thread(System.out::println).start();
//		ExecutorService exec = Executors.newCachedThreadPool();
//		exec.submit(System.out::println);
//		submit方法有一个带有Callable <T>参数的重载 ,导致了编译不过
	}

}
