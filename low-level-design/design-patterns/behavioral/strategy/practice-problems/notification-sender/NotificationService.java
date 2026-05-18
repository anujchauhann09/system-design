class NotificationService {

    NotificationStrategy notificationStrategy;

    NotificationService(NotificationStrategy notificationStrategy) {
        this.notificationStrategy = notificationStrategy;
    }

    public void sendNotification(String message) {
        notificationStrategy.sendMessage(message);
    }
}