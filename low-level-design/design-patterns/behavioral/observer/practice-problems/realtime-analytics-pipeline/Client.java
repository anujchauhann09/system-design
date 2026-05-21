class Client {
    public static void main(String[] args) {
        DataPipeline pipeline = new DataPipeline();

        pipeline.addProcessor(new MetricsCounter());
        pipeline.addProcessor(new FraudDetector());
        pipeline.addProcessor(new DashboardUpdater());
        pipeline.addProcessor(new AlertSystem());

        pipeline.ingest(new DataEvent("PURCHASE", "Alice", 1500));
        pipeline.ingest(new DataEvent("PURCHASE", "Bob", 75000));   // fraud alert
        pipeline.ingest(new DataEvent("LOGIN",    "Carol", 0));
        pipeline.ingest(new DataEvent("ERROR",    "system", 0));    // critical alert
    }
}
