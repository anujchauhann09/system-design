// Flags transactions above ₹1,00,000 as suspicious
class HighAmountRule implements FraudDetectionStrategy {
    @Override
    public boolean isFraudulent(Transaction transaction) {
        return transaction.amount > 100000;
    }
}
