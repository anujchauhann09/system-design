class PendingState implements PaymentState {

    @Override
    public void authorize(Payment payment)  { System.out.println("Already authorized."); }

    @Override
    public void capture(Payment payment) {
        System.out.println("[" + payment.getPaymentId() + "] ₹" + payment.getAmount() + " captured successfully.");
        payment.setState(new SuccessState());
    }

    @Override
    public void fail(Payment payment, String reason) {
        System.out.println("[" + payment.getPaymentId() + "] Capture failed: " + reason);
        payment.setState(new FailedState());
    }

    @Override
    public void refund(Payment payment)     { System.out.println("Cannot refund. Payment not captured yet."); }

    @Override
    public void chargeback(Payment payment) { System.out.println("Cannot chargeback. Payment not captured yet."); }
}
