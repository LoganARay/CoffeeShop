
public class Order {
    private Beverage beverage;
    private String orderType; // "Dine-In", "To-Go", or "Delivery"
    private double totalCost;

    public Order(Beverage beverage, String orderType) {
        this.beverage = beverage;
        this.orderType = orderType;
        this.totalCost = calculateFinalPrice();
    }

    /**
     * Handles different order types.
     */
    private double calculateFinalPrice() {
        double basePrice = 5.00; // Standard price for any drink

        //Delivery costs extra
        if (orderType.equalsIgnoreCase("Delivery")) {
            return basePrice + 5.00; // $5 delivery fee
        }
        return basePrice;
    }

    /**
     * Prints the final receipt and preparation instructions.
     */
    public void processOrder() {
        System.out.println("New Order : " + orderType.toUpperCase() + " ---");

        // Polymorphism: Calls the specific prepare() method of the drink
        beverage.prepare();

        System.out.println("Details: " + beverage.getSize() + " " + beverage.getType());

        // Specific packaging notes based on order type
        if (orderType.equalsIgnoreCase("To-Go")) {
            System.out.println("Packaging: Paper cup with sleeve and lid.");
        } else if (orderType.equalsIgnoreCase("Dine-In")) {
            System.out.println("Packaging: Ceramic mug with tray.");
        } else if (orderType.equalsIgnoreCase("Delivery")) {
            System.out.println("Packaging: Sealed bag with safety sticker.");
        }

        System.out.println("Total Cost: $" + totalCost);
        System.out.println("----------------------------\n");
    }
}
