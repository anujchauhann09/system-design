class OrderService {

    void createOrder(Order order) {
        System.out.println("Order created: " + order.foodItem + " for " + order.customerName);
    }
}
