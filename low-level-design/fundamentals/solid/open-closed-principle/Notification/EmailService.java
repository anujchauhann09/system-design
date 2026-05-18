class EmailService implements NotificationSender {

    public void sendNotification(String message) {
        System.out.println("Sending " + message + " via Email");
    }
}