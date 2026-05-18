class CashPayment extends PaymentMethod {

    @Override
    boolean processPayment(double amount) {
        System.out.println("Cash payment received: " + amount);
        return true;
    }

    @Override
    boolean refund(double amount) {
        System.out.println("Cash refund given: " + amount);
        return true;
    }
}
