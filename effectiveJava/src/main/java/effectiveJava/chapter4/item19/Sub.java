package effectiveJava.chapter4.item19;

import java.time.Instant;

/**
 * 
 * 类 @code(Sub)
 *
 * <p>功能简介：
 *
 * <p>覆写了这个可覆写方法的子类，这个方法由Super的唯一构造子错误地调用：
 *
 * <p>创建时间：2019年4月2日
 *
 * @author chenxj
 */
public final class Sub extends Super { 
    // 空白符号常量，由构造子设置
    private final Instant instant;

    Sub() { 
        instant = Instant.now();
    }

    // 超类构造子调用的覆写方法 
    @Override public void overrideMe() { 
    	instant.getClass();//初始化以前调用了父类构造，而父类构造调用了未初始化的 instant，会抛空指针异常
        System.out.println(instant); 
    }

    public static void main(String[] args) { 
        Sub sub = new Sub(); 
        sub.overrideMe(); 
    }
}