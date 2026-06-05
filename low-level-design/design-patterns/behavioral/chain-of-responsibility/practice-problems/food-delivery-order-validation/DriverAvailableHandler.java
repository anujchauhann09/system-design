class DriverAvailableHandler extends Handler {

    @Override
    public void handle(Order order) {
        if (!order.isDriverAvailable()) {
            System.out.println("Order " + order.getId() + " rejected: no driver available");
            return;   // short-circuit the chain
        }
        System.out.println("[OK] driver assigned");
        forward(order);
    }
}
