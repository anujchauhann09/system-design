public interface NotificationFactory {

    EmailSender createEmailSender();

    SmsSender createSmsSender();
}
