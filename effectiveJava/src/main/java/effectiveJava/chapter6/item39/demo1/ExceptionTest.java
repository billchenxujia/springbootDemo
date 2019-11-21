package effectiveJava.chapter6.item39.demo1;

//Annotation type with a parameter
import java.lang.annotation.*;

/**
 * 
 * 类 @code(ExceptionTest)
 *
 * <p>
 * 功能简介：
 * <p>
 * 注解中数组参数的语法很灵活。 它针对单元素数组进行了优化。
 * 所有以前的ExceptionTest注解仍然适用于ExceptionTest的新数组参数版本，并且会生成单元素数组。
 * 要指定一个多元素数组，请使用花括号将这些元素括起来，并用逗号分隔它们：
 * <p>
 * 创建时间：2019年4月16日
 *
 * @author chenxj
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
	Class<? extends Exception>[] value();

}