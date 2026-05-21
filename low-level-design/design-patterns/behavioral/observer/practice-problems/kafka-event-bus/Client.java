class Client {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();

        PaymentService   payment   = new PaymentService();
        EmailService     email     = new EmailService();
        InventoryService inventory = new InventoryService();
        AnalyticsService analytics = new AnalyticsService();

        eventBus.subscribe("order.placed",   payment);
        eventBus.subscribe("order.placed",   email);
        eventBus.subscribe("order.placed",   inventory);
        eventBus.subscribe("order.placed",   analytics);
        eventBus.subscribe("payment.failed", email);
        eventBus.subscribe("payment.failed", analytics);

        eventBus.publish("order.placed",   "Order #1001 placed by user Alice");
        eventBus.publish("payment.failed", "Payment failed for Order #1002");
        eventBus.publish("user.signup",    "New user Bob signed up"); // no subscribers
    }
}
