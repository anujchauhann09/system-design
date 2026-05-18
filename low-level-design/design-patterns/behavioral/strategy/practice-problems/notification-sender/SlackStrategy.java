class SlackStrategy implements NotificationStrategy {

    public void sendMessage(String message) {
        System.out.println("Sending message via Slack: " + message);
    }
}