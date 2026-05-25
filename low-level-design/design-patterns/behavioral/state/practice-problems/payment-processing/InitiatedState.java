// Payment created, waiting for bank authorization
class InitiatedState implements PaymentState {

    @Override
    public void authorize(Payment payment) {
        System.out.println("[" + payment.getPaymentId() + "] Authorized by bank. Awaiting capture.");
        payment.setState(new PendingState());
    }

    @Override
    public void capture(Payment payment)    { System.out.println("Authorize first before capture."); }

    @Override
    public void fail(Payment payment, String reason) {
        System.out.println("[" + payment.getPaymentId() + "] Payment failed: " + reason);
        payment.setState(new FailedState());
    }

    @Override
    public void refund(Payment payment)     { System.out.println("Cannot refund. Payment not completed."); }

    @Override
    public void chargeback(Payment payment) { System.out.println("Cannot chargeback. Payment not completed."); }
}
