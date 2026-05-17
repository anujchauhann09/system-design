class EmailService implements MessageSender {

    @Override
    public void sendMessage(String message) {
        System.out.println("Email sent: " + message);
    }
}
