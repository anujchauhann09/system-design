class Order {
    String orderId;
    String customerName;
    String foodItem;
    double amount;

    Order(String orderId, String customerName, String foodItem, double amount) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.foodItem = foodItem;
        this.amount = amount;
    }
}
