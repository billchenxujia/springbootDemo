package effectiveJava.chapter6.item39.demo2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 类 @code(ExceptionTestContainer)
 *
 * <p>
 *  功能简介：
 * <p>
* 
 * <p>
 *  创建时间：2019年4月16日
 *
 * @author chenxj
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTestContainer {
    ExceptionTest[] value();
}
