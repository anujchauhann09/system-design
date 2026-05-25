class ReturnedState implements OrderState {

    public void pay(Order order, double amount) { System.out.println("Order returned. No payment needed."); }
    public void pack(Order order)               { System.out.println("Order already returned."); }
    public void ship(Order order)               { System.out.println("Order already returned."); }
    public void deliver(Order order)            { System.out.println("Order already returned."); }
    public void cancel(Order order)             { System.out.println("Order already returned."); }
    public void returnOrder(Order order)        { System.out.println("Return already processed."); }
}
