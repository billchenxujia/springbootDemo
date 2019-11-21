package effectiveJava.chapter6.item39.demo1;

//Marker annotation type declaration
import java.lang.annotation.*;

/**

* Indicates that the annotated method is a test method.

* Use only on parameterless static methods.

*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {

}
