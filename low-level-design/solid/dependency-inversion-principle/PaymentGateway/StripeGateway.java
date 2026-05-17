class StripeGateway implements PaymentGateway {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Stripe: processing payment of " + amount);
        return true;
    }
}
