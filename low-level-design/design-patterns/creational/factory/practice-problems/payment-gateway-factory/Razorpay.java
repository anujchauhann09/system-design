class Razorpay implements PaymentGateway {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Razorpay");
    }
}
