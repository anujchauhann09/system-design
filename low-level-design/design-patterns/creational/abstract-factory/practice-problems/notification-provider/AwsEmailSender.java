public class AwsEmailSender
        implements EmailSender {

    @Override
    public void sendEmail(String message) {
        System.out.println("AWS SES email: " + message);
    }
}
