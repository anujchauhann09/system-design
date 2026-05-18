// Flags transactions from outside India as suspicious
class UnusualLocationRule implements FraudDetectionStrategy {
    @Override
    public boolean isFraudulent(Transaction transaction) {
        return !transaction.location.equalsIgnoreCase("India");
    }
}
