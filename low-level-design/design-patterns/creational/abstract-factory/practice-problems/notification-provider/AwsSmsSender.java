public class AwsSmsSender
        implements SmsSender {

    @Override
    public void sendSms(String message) {
        System.out.println("AWS SNS sms: " + message);
    }
}
