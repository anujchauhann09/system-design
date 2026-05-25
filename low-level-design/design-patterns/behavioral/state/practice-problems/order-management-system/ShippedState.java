class ShippedState implements OrderState {

    public void pay(Order order, double amount) { System.out.println("Already paid."); }
    public void pack(Order order)               { System.out.println("Already packed."); }
    public void ship(Order order)               { System.out.println("Already shipped."); }

    public void deliver(Order order) {
        System.out.println("Order " + order.getOrderId() + " delivered.");
        order.setState(new DeliveredState());
    }

    public void cancel(Order order) {
        System.out.println("Order " + order.getOrderId() + " cancelled while in transit. Refund initiated.");
        order.setState(new CancelledState());
    }

    public void returnOrder(Order order) { System.out.println("Order not delivered yet. Cannot return."); }
}
