class EmailSender implements NotificationSender {

    public void send(String message) {
        System.out.println("Sending message via email: " + message);
    }
}