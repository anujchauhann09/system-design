public class AzureNotificationFactory
        implements NotificationFactory {

    @Override
    public EmailSender createEmailSender() {
        return new AzureEmailSender();
    }

    @Override
    public SmsSender createSmsSender() {
        return new AzureSmsSender();
    }
}
