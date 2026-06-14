public class Application {

    private EmailSender emailSender;
    private SmsSender smsSender;

    public Application(NotificationFactory factory) {

        this.emailSender =
                factory.createEmailSender();

        this.smsSender =
                factory.createSmsSender();
    }

    public void notifyUser(String message) {
        emailSender.sendEmail(message);
        smsSender.sendSms(message);
    }

    public static void main(String[] args) {

        // pick a provider once. Swap this single line to switch
        // the entire notification family — no other code changes
        NotificationFactory factory =
                new AwsNotificationFactory();

        Application app =
                new Application(factory);

        app.notifyUser("Your order has shipped");
    }
}
