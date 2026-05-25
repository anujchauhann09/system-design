class Payment {
    private PaymentState state;
    private String paymentId;
    private double amount;

    Payment(String paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.state = new InitiatedState();
        System.out.println("Payment " + paymentId + " initiated for ₹" + amount);
    }

    void setState(PaymentState state)   { this.state = state; }
    String getPaymentId()               { return paymentId; }
    double getAmount()                  { return amount; }

    void authorize()                    { state.authorize(this); }
    void capture()                      { state.capture(this); }
    void fail(String reason)            { state.fail(this, reason); }
    void refund()                       { state.refund(this); }
    void chargeback()                   { state.chargeback(this); }
}
