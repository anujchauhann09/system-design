public class AzureSmsSender
        implements SmsSender {

    @Override
    public void sendSms(String message) {
        System.out.println("Azure Communication sms: " + message);
    }
}
