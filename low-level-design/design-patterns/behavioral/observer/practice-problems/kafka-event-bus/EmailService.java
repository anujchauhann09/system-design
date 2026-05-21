class EmailService implements EventListener {

    @Override
    public void onEvent(String topic, String message) {
        System.out.println("[EmailService] Sending email for event: " + message);
    }
}
