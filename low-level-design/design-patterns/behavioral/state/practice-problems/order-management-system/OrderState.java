interface OrderState {
    void pay(Order order, double amount);
    void pack(Order order);
    void ship(Order order);
    void deliver(Order order);
    void cancel(Order order);
    void returnOrder(Order order);
}