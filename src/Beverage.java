public abstract class Beverage {
    // Protected allows subclasses like Latte to access these directly
    protected String type;
    protected String temperature;
    protected String size;
    protected String milk;
    protected int shots;
    protected String sweetener;

    // Constructor that the Builder calls
    protected Beverage(BeverageBuilder<?> builder) {
        this.type = builder.type;
        this.temperature = builder.temperature;
        this.size = builder.size;
        this.milk = builder.milk;
        this.shots = builder.shots;
        this.sweetener = builder.sweetener;
    }

    // Getters for external access
    public String getType() {
        return type; }
    public String getTemperature() {
        return temperature;
    }
    public String getSize() {
        return size;
    }
    public String getMilk() {
        return milk;
    }
    public int getShots() {
        return shots;
    }
    public String getSweetener() {
        return sweetener;
    }

    // Each specific drink will implement its own preparation logic
    public abstract void prepare();

    // Inner Build Class
    public static abstract class BeverageBuilder<T extends BeverageBuilder<T>> {
        protected String type;
        protected String temperature;
        protected String size;
        protected String milk;
        protected int shots;
        protected String sweetener;

        public BeverageBuilder(String type) {
            this.type = type;
        }

        public T setTemperature(String temperature) {
            this.temperature = temperature;
            return self();
        }

        public T setSize(String size) {
            this.size = size;
            return self();
        }

        public T setMilk(String milk) {
            this.milk = milk;
            return self();
        }

        public T setShots(int shots) {
            this.shots = shots;
            return self();
        }

        public T setSweetener(String sweetener) {
            this.sweetener = sweetener;
            return self();
        }

        // Subclasses use this to return 'this' as the correct type
        protected abstract T self();

        // The final method to return the Beverage object
        public abstract Beverage build();
    }
}
