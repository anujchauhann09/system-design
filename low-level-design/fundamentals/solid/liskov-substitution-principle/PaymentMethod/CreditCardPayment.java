class CreditCardPayment extends PaymentMethod {

    @Override
    boolean processPayment(double amount) {
        System.out.println("Credit card payment processed: " + amount);
        return true;
    }

    @Override
    boolean refund(double amount) {
        System.out.println("Credit card refund processed: " + amount);
        return true;
    }
}
