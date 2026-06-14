public class AwsNotificationFactory
        implements NotificationFactory {

    @Override
    public EmailSender createEmailSender() {
        return new AwsEmailSender();
    }

    @Override
    public SmsSender createSmsSender() {
        return new AwsSmsSender();
    }
}
