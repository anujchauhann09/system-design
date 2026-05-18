class FraudDetectionService {
    FraudDetectionStrategy strategy;

    FraudDetectionService(FraudDetectionStrategy strategy) {
        this.strategy = strategy;
    }

    void checkTransaction(Transaction transaction) {
        if (strategy.isFraudulent(transaction)) {
            System.out.println("FRAUD ALERT for user: " + transaction.userId);
        } else {
            System.out.println("Transaction is safe for user: " + transaction.userId);
        }
    }
}
