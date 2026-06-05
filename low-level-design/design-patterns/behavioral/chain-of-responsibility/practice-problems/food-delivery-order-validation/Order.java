class Order {

    private final String id;
    private final boolean restaurantOpen;
    private final boolean driverAvailable;
    private final boolean paymentSuccess;
    private final boolean inventoryAvailable;

    public Order(String id, boolean restaurantOpen, boolean driverAvailable,
                 boolean paymentSuccess, boolean inventoryAvailable) {
        this.id = id;
        this.restaurantOpen = restaurantOpen;
        this.driverAvailable = driverAvailable;
        this.paymentSuccess = paymentSuccess;
        this.inventoryAvailable = inventoryAvailable;
    }

    public String getId() {
        return id;
    }

    public boolean isRestaurantOpen() {
        return restaurantOpen;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public boolean isPaymentSuccess() {
        return paymentSuccess;
    }

    public boolean isInventoryAvailable() {
        return inventoryAvailable;
    }
}
