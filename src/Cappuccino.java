
public class Cappuccino extends Beverage {

    private Cappuccino(Builder builder) {
        super(builder);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing a " + size + " Cappuccino:");
        System.out.println(" -> Pulling " + shots + " espresso shots.");
        System.out.println(" -> Adding heavy foam and " + milk + " milk.");
        System.out.println("Done!");
    }

    public static class Builder extends Beverage.BeverageBuilder<Builder> {
        public Builder() {
            super("Cappuccino");
        }

        /**
         * Espresso-only customization.
         * Requirement: 1, 2, or 3 shots only.
         */
        public Builder setShots(int shots) {
            if (shots >= 1 && shots <= 3) {
                this.shots = shots;
            } else {
                System.out.println("Note: BaseDrinkComponents.Shots must be between 1 and 3.");
            }
            return this;
        }

        @Override
        protected Builder self() { return this; }

        @Override
        public Cappuccino build() {
            return new Cappuccino(this);
        }
    }
}
