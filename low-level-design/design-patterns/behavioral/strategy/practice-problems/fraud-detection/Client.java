class Client {
    public static void main(String[] args) {
        Transaction t1 = new Transaction("user1", 150000, "India", 2);
        Transaction t2 = new Transaction("user2", 5000, "USA", 1);
        Transaction t3 = new Transaction("user3", 2000, "India", 8);

        FraudDetectionService highAmount = new FraudDetectionService(new HighAmountRule());
        FraudDetectionService unusualLocation = new FraudDetectionService(new UnusualLocationRule());
        FraudDetectionService velocity = new FraudDetectionService(new VelocityRule());

        highAmount.checkTransaction(t1);       // FRAUD — amount > 1L
        unusualLocation.checkTransaction(t2);  // FRAUD — location is USA
        velocity.checkTransaction(t3);         // FRAUD — 8 transactions in last hour
    }
}
