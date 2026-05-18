class EmailStrategy implements NotificationStrategy {

    public void sendMessage(String message) {
        System.out.println("Sending message via Email: " + message);
    }
}