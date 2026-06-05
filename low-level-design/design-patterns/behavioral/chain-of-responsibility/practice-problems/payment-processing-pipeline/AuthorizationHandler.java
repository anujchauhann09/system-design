class AuthorizationHandler extends Handler {

    // bank per-transaction limit without step-up authorization
    private static final double AUTH_LIMIT = 10_000;

    @Override
    public void handle(Payment payment) {
        if (payment.getAmount() > AUTH_LIMIT) {
            System.out.println("Payment " + payment.getId() + " declined: amount exceeds auth limit ($"
                    + AUTH_LIMIT + ")");
            return;   // short-circuit the chain
        }
        System.out.println("[OK] authorized by issuing bank");
        forward(payment);
    }
}
