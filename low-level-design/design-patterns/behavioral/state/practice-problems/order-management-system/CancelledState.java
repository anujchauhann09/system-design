class CancelledState implements OrderState {

    public void pay(Order order, double amount) { System.out.println("Order is cancelled. Cannot pay."); }
    public void pack(Order order)               { System.out.println("Order is cancelled."); }

    // Rule: Cancelled order cannot be shipped
    public void ship(Order order)               { System.out.println("Cannot ship a cancelled order."); }
    public void deliver(Order order)            { System.out.println("Order is cancelled."); }
    public void cancel(Order order)             { System.out.println("Already cancelled."); }
    public void returnOrder(Order order)        { System.out.println("Order is cancelled. Cannot return."); }
}
