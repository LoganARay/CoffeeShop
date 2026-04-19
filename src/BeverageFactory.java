public class BeverageFactory {

    /**

     Factory method to get a beverage builder.*/
    public static Beverage.BeverageBuilder<?> getBeverage(String type) {
        if (type == null) {
            return null;}

        // Using a switch statement to decide which concrete Builder to return
        switch (type.toLowerCase()) {
            case "coffee":
                return new Coffee.Builder();

            case "latte":
                return new Latte.Builder();

            case "cappuccino":
                return new Cappuccino.Builder();

            case "tea":
                return new Tea.Builder();

            default:
                // If the type is unrecognized, we throw an error or return null.
                System.out.println("Error: " + type + " is not on the menu.");
                return null;
        }
    }
}