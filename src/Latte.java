
public class Latte extends Beverage {

    // Constructor is private to ensure only the Latte.Builder can create it.
    private Latte(Builder builder) {
        super(builder);
    }

    /**
     * Specifically handles the preparation logic for a Latte (steaming milk + espresso).
     */
    @Override
    public void prepare() {
        System.out.println("Steaming " + milk + " milk and pulling " + shots + " espresso shots...");
        System.out.println("Your " + size + " " + type + " is ready!");
    }

    /**
     * Concrete Builder for Latte.
     * It inherits all customization methods (setSize, setMilk, etc.) from BeverageBuilder.
     */
    public static class Builder extends Beverage.BeverageBuilder<Builder> {
        public Builder() {
            super("Latte");
        }
        //Latte shots
        public Builder setShots(int shots) {
            if (shots >= 1 && shots <= 3) {
                this.shots = shots;
            } else {
                System.out.println("Invalid shot count. Must be 1, 2, or 3.");
            }
            return this;
        }

        // Returns this specific builder instance to keep method chaining active.
        @Override
        protected Builder self() {
            return this;
        }

        // Returns a concrete Latte object once customization is complete.
        @Override
        public Latte build() {
            return new Latte(this);
        }
    }
}
