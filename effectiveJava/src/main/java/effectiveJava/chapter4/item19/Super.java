package effectiveJava.chapter4.item19;

/**
 * 
 * 类 @code(Super)
 *
 * <p>功能简介：
 *
 * <p>继承构造器调用可复写方法错误演示
 *
 * <p>创建时间：2019年4月2日
 *
 * @author chenxj
 */
public class Super { 
    // 已破坏 - 构造子调用了一个可覆写的方法 
    public Super() { 
        overrideMe(); 
    } 
    public void overrideMe() { 
    } 
}
