class Stripe implements PaymentGateway {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Stripe");
    }
}
