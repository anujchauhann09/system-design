class Client {
    public static void main(String[] args) {
        Handler restaurant = new RestaurantOpenHandler();
        Handler driver     = new DriverAvailableHandler();
        Handler payment    = new PaymentSuccessHandler();
        Handler inventory  = new InventoryAvailableHandler();

        restaurant.setNext(driver);
        driver.setNext(payment);
        payment.setNext(inventory);

        Handler chain = restaurant;   // every order enters at the restaurant check

        System.out.println("--- fully valid order ---");
        chain.handle(new Order("A1", true, true, true, true));

        System.out.println("\n--- restaurant closed ---");
        chain.handle(new Order("A2", false, true, true, true));

        System.out.println("\n--- no driver ---");
        chain.handle(new Order("A3", true, false, true, true));

        System.out.println("\n--- payment failed ---");
        chain.handle(new Order("A4", true, true, false, true));

        System.out.println("\n--- out of stock ---");
        chain.handle(new Order("A5", true, true, true, false));
    }
}
