class DeliveredState implements OrderState {

    public void pay(Order order, double amount) { System.out.println("Already paid."); }
    public void pack(Order order)               { System.out.println("Already delivered."); }
    public void ship(Order order)               { System.out.println("Already delivered."); }
    public void deliver(Order order)            { System.out.println("Already delivered."); }

    // Rule: Delivered order cannot be cancelled
    public void cancel(Order order) {
        System.out.println("Cannot cancel a delivered order.");
    }

    public void returnOrder(Order order) {
        System.out.println("Return request raised for order " + order.getOrderId() + ". Refund initiated.");
        order.setState(new ReturnedState());
    }
}
