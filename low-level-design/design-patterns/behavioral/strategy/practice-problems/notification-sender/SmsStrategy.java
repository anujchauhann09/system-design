class SmsStrategy implements NotificationStrategy {

    public void sendMessage(String message) {
        System.out.println("Sending message via SMS: " + message);
    }
}