class Wallet implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing wallet payment of: " + amount);
    }
}
