class CardPayment extends Payment {
    String cardNumber;

    void processPayment(double amount) {
        if (!validateAmount(amount)) return;
        System.out.println("Processing card payment via " + cardNumber);
    }
}
