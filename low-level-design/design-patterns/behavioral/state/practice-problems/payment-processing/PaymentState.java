interface PaymentState {
    void authorize(Payment payment);
    void capture(Payment payment);
    void fail(Payment payment, String reason);
    void refund(Payment payment);
    void chargeback(Payment payment);
}
