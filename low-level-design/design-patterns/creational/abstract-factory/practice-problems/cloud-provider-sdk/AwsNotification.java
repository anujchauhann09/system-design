public class AwsNotification
        implements Notification {

    @Override
    public void notify(String message) {
        System.out.println("SNS notified: " + message);
    }
}
