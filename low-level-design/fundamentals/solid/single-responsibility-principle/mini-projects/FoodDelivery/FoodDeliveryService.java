class FoodDeliveryService {

    OrderService orderService = new OrderService();
    PaymentService paymentService = new PaymentService();
    EmailService emailService = new EmailService();
    StorageService storageService = new StorageService();

    void placeOrder(Order order) {
        orderService.createOrder(order);
        paymentService.processPayment(order);
        storageService.save(order);
        emailService.sendEmail(order);
    }
}
