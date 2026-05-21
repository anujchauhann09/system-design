class Client {
    public static void main(String[] args) {
        NotificationChannel email = new EmailChannel();
        NotificationChannel sms   = new SmsChannel();
        NotificationChannel push  = new PushChannel();

        User alice = new User("Alice");
        alice.addChannel(email);
        alice.addChannel(push);

        User bob = new User("Bob");
        bob.addChannel(sms);

        User carol = new User("Carol");
        carol.addChannel(email);
        carol.addChannel(sms);
        carol.addChannel(push);

        NotificationService service = new NotificationService();
        service.register(alice);
        service.register(bob);
        service.register(carol);

        service.broadcast("Your order #1001 has been shipped!");

        service.unregister(bob);
        service.broadcast("Flash sale starts in 1 hour!");
    }
}
