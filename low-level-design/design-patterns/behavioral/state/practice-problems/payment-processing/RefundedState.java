class RefundedState implements PaymentState {

    @Override
    public void authorize(Payment payment)  { System.out.println("Payment already refunded."); }

    @Override
    public void capture(Payment payment)    { System.out.println("Payment already refunded."); }

    @Override
    public void fail(Payment payment, String reason) { System.out.println("Payment already refunded."); }

    @Override
    public void refund(Payment payment)     { System.out.println("Already refunded."); }

    @Override
    public void chargeback(Payment payment) { System.out.println("Already refunded. Chargeback not applicable."); }
}
