class FraudDetector implements AnalyticsProcessor {

    private static final double THRESHOLD = 50000;

    @Override
    public void process(DataEvent event) {
        if (event.eventType.equals("PURCHASE") && event.value > THRESHOLD) {
            System.out.println("[FraudDetector] ALERT: Suspicious transaction by "
                    + event.userId + " — ₹" + event.value);
        }
    }
}
