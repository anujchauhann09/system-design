class RazorpayGateway implements PaymentGateway {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Razorpay: processing payment of " + amount);
        return true;
    }
}
