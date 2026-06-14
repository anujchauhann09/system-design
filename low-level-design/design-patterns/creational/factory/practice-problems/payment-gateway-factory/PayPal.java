class PayPal implements PaymentGateway {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via PayPal");
    }
}
