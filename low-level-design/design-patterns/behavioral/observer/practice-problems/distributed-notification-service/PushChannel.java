class PushChannel implements NotificationChannel {
    @Override
    public void send(String userId, String message) {
        System.out.println("[Push] To " + userId + ": " + message);
    }
}
