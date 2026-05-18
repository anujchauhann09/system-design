class PaymentService {

    void processPayment(Order order) {
        System.out.println("Payment of " + order.amount + " processed for order " + order.orderId);
    }
}
