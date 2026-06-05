class NotificationHandler extends Handler {

    @Override
    public void handle(Payment payment) {
        System.out.println("[Notify] " + payment.getPayer() + ": payment " + payment.getId() + " succeeded");
        forward(payment);   // end of chain, but stays extensible
    }
}
