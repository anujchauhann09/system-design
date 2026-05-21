class EmailChannel implements NotificationChannel {
    @Override
    public void send(String userId, String message) {
        System.out.println("[Email] To " + userId + ": " + message);
    }
}
