public class AzureNotification
        implements Notification {

    @Override
    public void notify(String message) {
        System.out.println("Azure Event Grid notified: " + message);
    }
}
