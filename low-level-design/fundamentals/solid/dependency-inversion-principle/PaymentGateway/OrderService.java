class OrderService {
    PaymentGateway paymentGateway;

    OrderService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    void placeOrder(double amount) {
        boolean success = paymentGateway.processPayment(amount);
        if (success) System.out.println("Order placed successfully.");
    }
}
