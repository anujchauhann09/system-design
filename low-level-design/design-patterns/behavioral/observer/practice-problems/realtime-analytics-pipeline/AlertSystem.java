class AlertSystem implements AnalyticsProcessor {

    @Override
    public void process(DataEvent event) {
        if (event.eventType.equals("ERROR") || event.eventType.equals("SYSTEM_FAILURE")) {
            System.out.println("[AlertSystem] CRITICAL ALERT: " + event.eventType
                    + " detected for " + event.userId);
        }
    }
}
