import java.util.ArrayList;
import java.util.List;

class DataPipeline {

    private List<AnalyticsProcessor> processors = new ArrayList<>();

    void addProcessor(AnalyticsProcessor processor) {
        processors.add(processor);
    }

    void ingest(DataEvent event) {
        System.out.println("\n[Pipeline] Ingesting event: " + event.eventType
                + " | user: " + event.userId + " | value: " + event.value);
        for (AnalyticsProcessor processor : processors) {
            processor.process(event);
        }
    }
}
