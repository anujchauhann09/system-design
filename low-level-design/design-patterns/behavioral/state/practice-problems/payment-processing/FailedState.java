class FailedState implements PaymentState {

    @Override
    public void authorize(Payment payment)  { System.out.println("Payment failed. Initiate a new payment."); }

    @Override
    public void capture(Payment payment)    { System.out.println("Payment failed. Cannot capture."); }

    @Override
    public void fail(Payment payment, String reason) { System.out.println("Payment already failed."); }

    @Override
    public void refund(Payment payment)     { System.out.println("Payment failed. Nothing to refund."); }

    @Override
    public void chargeback(Payment payment) { System.out.println("Payment failed. Cannot chargeback."); }
}
