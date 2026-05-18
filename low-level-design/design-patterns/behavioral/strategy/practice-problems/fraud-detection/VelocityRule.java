// Flags if more than 5 transactions in the last hour
class VelocityRule implements FraudDetectionStrategy {
    @Override
    public boolean isFraudulent(Transaction transaction) {
        return transaction.transactionsInLastHour > 5;
    }
}
