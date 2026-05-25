class Order {
    private OrderState state;
    private String orderId;

    Order(String orderId) {
        this.orderId = orderId;
        this.state = new PlacedState();
        System.out.println("Order " + orderId + " placed.");
    }

    void setState(OrderState state) { this.state = state; }
    String getOrderId()             { return orderId; }

    void pay(double amount)  { state.pay(this, amount); }
    void pack()              { state.pack(this); }
    void ship()              { state.ship(this); }
    void deliver()           { state.deliver(this); }
    void cancel()            { state.cancel(this); }
    void returnOrder()       { state.returnOrder(this); }
}
