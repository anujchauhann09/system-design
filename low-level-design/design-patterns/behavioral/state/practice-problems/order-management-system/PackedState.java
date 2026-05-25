class PackedState implements OrderState {

    public void pay(Order order, double amount) { System.out.println("Already paid."); }
    public void pack(Order order)               { System.out.println("Already packed."); }

    public void ship(Order order) {
        System.out.println("Order " + order.getOrderId() + " shipped.");
        order.setState(new ShippedState());
    }

    public void deliver(Order order) { System.out.println("Order not shipped yet."); }

    public void cancel(Order order) {
        System.out.println("Order " + order.getOrderId() + " cancelled. Refund initiated.");
        order.setState(new CancelledState());
    }

    public void returnOrder(Order order) { System.out.println("Order not delivered yet. Cannot return."); }
}
