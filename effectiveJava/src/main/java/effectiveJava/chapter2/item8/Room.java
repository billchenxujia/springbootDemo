package effectiveJava.chapter2.item8;

import java.lang.ref.Cleaner;

/**
 * 
 * 类 @code(Room)
 *
 * <p>功能简介：
 *
 * <p>cleanner实现安全保障演示（因为没有jdk9，故模拟了cleaner类）
 * 
 * <p>1.finalizer和cleaner都是只能用来安全保障或者关闭非关键的本地资源的
 * cleaner是finalizer的替代者。这两者本身调用都依赖于垃圾回收算法，而算法
 * 本身就有着千差万别的实现，在不同的jvm中他们的调用是无法保证的。而且
 * 他们的运行优先级是低于其他正常线程的。但即使是上述两个用途，也应该非常慎重
 * 思考再三
 * 
 * <p>2.finalizer是有着容易收到finalizer攻击的重大危险，避免遭受攻击就是
 * 在你自己的类中，重写一个final的finalizer方法。攻击原理是finalizer终止中产生的异常
 * 不会被捕获，就意味着可以写一个恶意攻击的子类来记录本应死去的对象，并调用不该
 * 调用也没有权限的调用的方法来随意破坏。使用cleaner的库有对它线程的控制因此不会出现这个问题
 * 
 * <p>3.使用它们关闭资源本身也会带来严重的性能影响
 *
 * <p>创建时间：2019年3月24日
 *
 * @author chenxj
 */
public class Room implements AutoCloseable { 
 private static final Cleaner cleaner = Cleaner.create();

 // 需要清理的资源。必须不引用Room！
 private static class State implements Runnable { 
     @SuppressWarnings("unused")
	int numJunkPiles; // 这个房间里面的垃圾堆数量

     State(int numJunkPiles) { 
         this.numJunkPiles = numJunkPiles; 
     }

     // 被close方法或者cleaner调用 
     @Override public void run() {
         System.out.println("Cleaning room");
         numJunkPiles = 0; 
     }
 }

 // 这个房间的状态，与我们的cleanable共享
 private final State state;

 // 我们的Cleanable. 当它符合垃圾回收条件时，清理房间
 private final Cleaner.Cleanable cleanable;

 public Room(int numJunkPiles) { 
     state = new State(numJunkPiles); 
     cleanable = cleaner.register(this, state); 
 }

 @Override public void close() { 
     cleanable.clean(); 
 }
}
