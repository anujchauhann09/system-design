class PlacedState implements OrderState {

    public void pay(Order order, double amount) {
        System.out.println("Payment of ₹" + amount + " received for order " + order.getOrderId());
        order.setState(new PaidState());
    }

    public void pack(Order order)        { System.out.println("Pay first before packing."); }
    public void ship(Order order)        { System.out.println("Pay first before shipping."); }
    public void deliver(Order order)     { System.out.println("Order not ready for delivery."); }

    public void cancel(Order order) {
        System.out.println("Order " + order.getOrderId() + " cancelled.");
        order.setState(new CancelledState());
    }

    public void returnOrder(Order order) { System.out.println("Order not delivered yet. Cannot return."); }
}
