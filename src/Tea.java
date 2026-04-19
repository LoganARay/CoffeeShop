
public class Tea extends Beverage {

    private Tea(Builder builder) {
        super(builder);
    }

    @Override
    public void prepare() {
        if(temperature==null){ //default temperature is Hot
            System.out.println("Steeping " + size + " Hot " + type + "...");
        }else{
            System.out.println("Steeping " + size + " " + temperature + " " + type + "...");
        }
        if (!sweetener.equals("None")) {
            System.out.println(" -> Stirring in " + sweetener + ".");
        }
        System.out.println("Tea is ready!");
    }

    public static class Builder extends Beverage.BeverageBuilder<Builder> {
        public Builder() {
            super("Tea");
        }

        public Tea.Builder setTemp(String temperature) {
            if (temperature=="Hot" || temperature=="Cold"){
                this.temperature = temperature;
            } else {
                System.out.println("Not a temperature option!");
            }
            return this;
        }

        @Override
        protected Builder self() { return this; }

        @Override
        public Tea build() {
            return new Tea(this);
        }
    }
}
