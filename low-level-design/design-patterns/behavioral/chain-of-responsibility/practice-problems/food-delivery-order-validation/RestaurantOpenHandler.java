class RestaurantOpenHandler extends Handler {

    @Override
    public void handle(Order order) {
        if (!order.isRestaurantOpen()) {
            System.out.println("Order " + order.getId() + " rejected: restaurant is closed");
            return;   // short-circuit the chain
        }
        System.out.println("[OK] restaurant is open");
        forward(order);
    }
}
