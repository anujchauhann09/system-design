class Client {

    public static void main(String args[]) {

        NotificationService email = new NotificationService(new EmailStrategy());
        NotificationService slack = new NotificationService(new SlackStrategy());
        NotificationService sms = new NotificationService(new SmsStrategy());

        email.sendNotification("Hey Anuj Chauhan.");
        slack.sendNotification("Hey Anuj Chauhan.");
        sms.sendNotification("Hey Anuj Chauhan.");
    }
}