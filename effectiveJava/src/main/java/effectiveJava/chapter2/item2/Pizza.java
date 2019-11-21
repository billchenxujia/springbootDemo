package effectiveJava.chapter2.item2;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * 
 * 类 @code(Pizza)
 *
 * <p>功能简介：
 *
 * <p>建造者模式演示：抽象类公共部分
 * 通过泛型确保了子类返回自己
 *
 * <p>创建时间：2019年3月23日
 *
 * @author chenxj
 */
public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
    final Set<Topping> toppings;
    
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }
        
        abstract Pizza build();
        
        // Subclasses must override this method to return "this"
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone(); // See Item 50
    }
}