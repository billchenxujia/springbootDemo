package effectiveJava.chapter9.item61;

/**
 * 
 * 类 @code(Unbelievable)
 *
 * <p>
 *  功能简介：
 * <p>
* 拆装包引发的问题演示；
* 包装类默认初始化值是null。引发空指针异常
 * <p>
 *  创建时间：2019年5月16日
 *
 * @author chenxj
 */
public class Unbelievable {
    static Integer i;

    public static void main(String[] args) {
        if (i == 42)
            System.out.println("Unbelievable");
    }
}
