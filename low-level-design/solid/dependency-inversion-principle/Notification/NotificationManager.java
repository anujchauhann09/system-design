class NotificationManager {
    MessageSender sender;

    NotificationManager(MessageSender sender) {
        this.sender = sender;
    }

    void notify(String message) {
        sender.sendMessage(message);
    }
}
