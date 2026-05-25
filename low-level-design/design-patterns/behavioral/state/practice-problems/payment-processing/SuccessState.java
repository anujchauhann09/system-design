class SuccessState implements PaymentState {

    @Override
    public void authorize(Payment payment)  { System.out.println("Payment already successful."); }

    @Override
    public void capture(Payment payment)    { System.out.println("Payment already captured."); }

    @Override
    public void fail(Payment payment, String reason) { System.out.println("Payment already successful. Cannot fail."); }

    @Override
    public void refund(Payment payment) {
        System.out.println("[" + payment.getPaymentId() + "] Refund of ₹" + payment.getAmount() + " initiated.");
        payment.setState(new RefundedState());
    }

    @Override
    public void chargeback(Payment payment) {
        System.out.println("[" + payment.getPaymentId() + "] Chargeback raised by customer.");
        payment.setState(new ChargebackState());
    }
}
