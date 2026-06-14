public class AzureEmailSender
        implements EmailSender {

    @Override
    public void sendEmail(String message) {
        System.out.println("Azure Communication email: " + message);
    }
}
