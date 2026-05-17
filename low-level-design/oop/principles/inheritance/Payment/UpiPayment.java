class UpiPayment extends Payment {
    String upiId;

    void processPayment(double amount) {
        if (!validateAmount(amount)) return;
        System.out.println("Processing UPI payment via " + upiId);
    }
}
