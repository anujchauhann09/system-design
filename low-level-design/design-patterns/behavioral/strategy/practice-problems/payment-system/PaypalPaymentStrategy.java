class PaypalPaymentStrategy implements PaymentStrategy {

    public void pay(double amount) {
        System.out.println("Paid: " + amount + " via Paypal.");
    }
}