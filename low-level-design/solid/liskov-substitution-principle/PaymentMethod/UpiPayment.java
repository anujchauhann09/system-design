class UpiPayment extends PaymentMethod {

    @Override
    boolean processPayment(double amount) {
        System.out.println("UPI payment processed: " + amount);
        return true;
    }

    @Override
    boolean refund(double amount) {
        System.out.println("UPI refund processed: " + amount);
        return true;
    }
}
