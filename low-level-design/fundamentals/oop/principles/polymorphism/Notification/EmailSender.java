class EmailSender implements NotificationSender {
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email: " + message);
    }
}
