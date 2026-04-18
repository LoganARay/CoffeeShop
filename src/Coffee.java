public class Coffee extends Beverage {
    private Coffee(Builder builder) {
        super(builder);
    }

    @Override
    public void prepare() {
        System.out.println("Brewing a fresh " + size + " " + temperature + " " + type + "...");
        if (!milk.equals("None")) {
            System.out.println("Adding a splash of " + milk + ".");
        }
    }

    public static class Builder extends Beverage.BeverageBuilder<Builder> {
        public Builder() {
            super("Coffee");
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Coffee build() {
            return new Coffee(this);
        }
    }
}
