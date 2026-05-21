class AnalyticsService implements EventListener {

    @Override
    public void onEvent(String topic, String message) {
        System.out.println("[AnalyticsService] Tracking event: " + message);
    }
}
