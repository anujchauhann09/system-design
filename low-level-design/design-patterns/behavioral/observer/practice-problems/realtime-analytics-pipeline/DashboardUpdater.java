class DashboardUpdater implements AnalyticsProcessor {

    @Override
    public void process(DataEvent event) {
        System.out.println("[Dashboard] Refreshing — " + event.eventType
                + " from " + event.userId);
    }
}
