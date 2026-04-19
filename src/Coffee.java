public class Coffee extends Beverage {
    private Coffee(Builder builder) {
        super(builder);
    }

    @Override
    public void prepare() {
        if(temperature==null){ //default temperature is Hot
            System.out.println("Brewing a fresh " + size + " Hot " + type + "...");
        }else{
            System.out.println("Brewing a fresh " + size + " " + temperature + " " + type + "...");
        }
        if (!milk.equals("None")) {
            System.out.println("Adding a splash of " + milk + ".");
        }
    }

    public static class Builder extends Beverage.BeverageBuilder<Builder> {
        public Builder() {
            super("Coffee");
        }

        public Coffee.Builder setShots(int shots) {
            if (shots >= 1 && shots <= 3) {
                this.shots = shots;
            } else {
                System.out.println("Invalid shot count. Must be 1, 2, or 3.");
            }
            return this;
        }

        public Coffee.Builder setTemp(String temperature) {
            if (temperature=="Hot" || temperature=="Cold"){
                this.temperature = temperature;
            } else {
                System.out.println("Not a temperature option!");
            }
            return this;
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
