public class GcpNotification
        implements Notification {

    @Override
    public void notify(String message) {
        System.out.println("GCP Pub/Sub notified: " + message);
    }
}
