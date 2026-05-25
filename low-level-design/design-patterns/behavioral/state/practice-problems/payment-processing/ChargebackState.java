class ChargebackState implements PaymentState {

    @Override
    public void authorize(Payment payment)  { System.out.println("Chargeback in progress."); }

    @Override
    public void capture(Payment payment)    { System.out.println("Chargeback in progress."); }

    @Override
    public void fail(Payment payment, String reason) { System.out.println("Chargeback in progress."); }

    @Override
    public void refund(Payment payment)     { System.out.println("Chargeback already raised. Refund not needed."); }

    @Override
    public void chargeback(Payment payment) { System.out.println("Chargeback already in progress."); }
}
