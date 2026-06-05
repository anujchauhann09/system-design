class BalanceCheckHandler extends Handler {

    @Override
    public void handle(Payment payment) {
        if (payment.getAmount() > payment.getAccountBalance()) {
            System.out.println("Payment " + payment.getId() + " declined: insufficient funds ($"
                    + payment.getAmount() + " > $" + payment.getAccountBalance() + ")");
            return;   // short-circuit the chain
        }
        System.out.println("[OK] sufficient balance");
        forward(payment);
    }
}
