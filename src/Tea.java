
public class Tea extends Beverage {

    private Tea(Builder builder) {
        super(builder);
    }

    @Override
    public void prepare() {
        System.out.println("Steeping " + size + " " + temperature + " " + type + "...");
        if (!sweetener.equals("None")) {
            System.out.println(" -> Stirring in " + sweetener + ".");
        }
        System.out.println("Tea is ready!");
    }

    public static class Builder extends Beverage.BeverageBuilder<Builder> {
        public Builder() {
            super("Tea");
        }

        @Override
        protected Builder self() { return this; }

        @Override
        public Tea build() {
            return new Tea(this);
        }
    }
}
