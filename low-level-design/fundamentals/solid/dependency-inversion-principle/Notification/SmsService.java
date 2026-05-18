class SmsService implements MessageSender {

    @Override
    public void sendMessage(String message) {
        System.out.println("SMS sent: " + message);
    }
}
