class Client {

    public static void main(String args[]) {
        PaymentStrategy paymentStrategy = new UpiPaymentStrategy();
        PaymentService paymentService = new PaymentService(paymentStrategy);

        paymentService.processPayment(100);
    }
}