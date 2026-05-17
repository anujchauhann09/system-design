class PushService implements NotificationSender {

    public void sendNotification(String message) {
        System.out.println("Sending " + message + " via Push");
    }
}