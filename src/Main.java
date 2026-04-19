public class Main {
    public static void main(String[] args) {

        // We ask the Factory for a Latte builder
        Latte.Builder latteBuilder = (Latte.Builder) BeverageFactory.getBeverage("Latte");

        // We use the Builder to customize step-by-step
        Beverage myLatte = latteBuilder
                .setSize("Large")
                .setMilk("Oat")
                .setShots(3)
                .setTemp("Cold")
                .build();

        // Wrap it in an Order and process it
        Order order1 = new Order(myLatte, "To-Go");
        order1.processOrder();


        // 2. Create a "Dine-In" Tea (Customized)
        Tea.Builder teaBuilder = (Tea.Builder) BeverageFactory.getBeverage("Tea");

        Beverage myTea = teaBuilder
                .setSize("Small")
                .setSweetener("Honey")
                .setTemp("Hot")
                .build();

        Order order2 = new Order(myTea, "Dine-In");
        order2.processOrder();


        // 3. Create a "Delivery" Cappuccino
        Cappuccino.Builder capBuilder = (Cappuccino.Builder) BeverageFactory.getBeverage("Cappuccino");

        Beverage myCap = capBuilder
                .setSize("Medium")
                .setShots(2) // Valid for espresso drinks!
                .setMilk("Almond")
                .build();

        Order order3 = new Order(myCap, "Delivery");
        order3.processOrder();


        Coffee.Builder cofBuilder = (Coffee.Builder) BeverageFactory.getBeverage("Coffee");

        Beverage myCof = cofBuilder
                .setSize("Medium")
                .setShots(2) // Valid for espresso drinks!
                .setMilk("Almond")
                .setTemp("Cold")
                .build();

        Order order4 = new Order(myCof, "Delivery");
        order4.processOrder();
    }
}