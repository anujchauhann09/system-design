class FraudDetectionHandler extends Handler {

    @Override
    public void handle(Payment payment) {
        if (payment.isSuspicious()) {
            System.out.println("Payment " + payment.getId() + " blocked: flagged by fraud detection");
            return;   // short-circuit the chain
        }
        System.out.println("[OK] fraud detection passed");
        forward(payment);
    }
}
