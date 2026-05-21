class ChatUser implements Observer {

    private String username;

    ChatUser(String username) {
        this.username = username;
    }

    @Override
    public void update(String sender, String message) {
        if (!sender.equals(username)) {
            System.out.println(username + " received from " + sender + ": " + message);
        }
    }
}
