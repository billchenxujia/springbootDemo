package effectiveJava.chapter2.item2;

import java.util.Objects;

/**
 * 
 * 类 @code(NyPizza)
 *
 * <p>功能简介：
 *
 * <p>建造者模式演示，子类及其内部builder类演示
 *
 * <p>创建时间：2019年3月23日
 *
 * @author chenxj
 */
public class NyPizza extends Pizza {
    public enum Size { SMALL, MEDIUM, LARGE }
    @SuppressWarnings("unused")
	private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override 
        public NyPizza build() {
            return new NyPizza(this);
        }

        @Override 
        protected Builder self() {
            return this;
        }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }   
}

