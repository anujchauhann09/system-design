class Payment {
    String paymentId;
    double amount;

    void displayInfo() {
        System.out.println("Payment ID: " + paymentId + " Amount: " + amount);
    }

    boolean validateAmount(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return false;
        }
        return true;
    }

    void processPayment(double amount) {
        System.out.println("Processing payment...");
    }
}
