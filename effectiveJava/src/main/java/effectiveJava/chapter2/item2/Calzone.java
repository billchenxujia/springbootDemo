package effectiveJava.chapter2.item2;

/**
 * 类{@code Calzone}
 * 
 * <p>功能简介：
 * 
 * <p>建造者模式演示，子类及其内部builder类演示
 * 
 * <p>创建时间：2019年3月20日
 * 
 * @author chenxj
 */
public class Calzone extends Pizza {
    @SuppressWarnings("unused")
	private final boolean sauceInside;
    
    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false; // Default

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }
        
        @Override 
        public Calzone build() {
            return new Calzone(this);
        }
        
        @Override 
        protected Builder self() {
            return this; 
        }
    }
    
    private Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

}
