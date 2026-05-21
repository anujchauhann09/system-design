class MetricsCounter implements AnalyticsProcessor {

    private int totalEvents = 0;
    private double totalRevenue = 0;

    @Override
    public void process(DataEvent event) {
        totalEvents++;
        if (event.eventType.equals("PURCHASE")) {
            totalRevenue += event.value;
        }
        System.out.println("[MetricsCounter] Events: " + totalEvents + " | Revenue: ₹" + totalRevenue);
    }
}
