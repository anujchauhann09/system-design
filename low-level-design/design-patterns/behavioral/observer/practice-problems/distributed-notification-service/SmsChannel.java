class SmsChannel implements NotificationChannel {
    @Override
    public void send(String userId, String message) {
        System.out.println("[SMS] To " + userId + ": " + message);
    }
}
