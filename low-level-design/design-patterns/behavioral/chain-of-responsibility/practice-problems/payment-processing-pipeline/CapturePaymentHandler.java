class CapturePaymentHandler extends Handler {

    @Override
    public void handle(Payment payment) {
        // the actual money movement - only reached once every check above has passed
        System.out.println("[OK] captured $" + payment.getAmount() + " from " + payment.getPayer());
        forward(payment);
    }
}
