class DataEvent {
    String eventType;
    String userId;
    double value;

    DataEvent(String eventType, String userId, double value) {
        this.eventType = eventType;
        this.userId = userId;
        this.value = value;
    }
}
