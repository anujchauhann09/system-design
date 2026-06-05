class Client {
    public static void main(String[] args) {
        Handler fraud         = new FraudDetectionHandler();
        Handler balance       = new BalanceCheckHandler();
        Handler authorization = new AuthorizationHandler();
        Handler capture       = new CapturePaymentHandler();
        Handler notification  = new NotificationHandler();

        fraud.setNext(balance);
        balance.setNext(authorization);
        authorization.setNext(capture);
        capture.setNext(notification);

        Handler pipeline = fraud;   // every payment enters at fraud detection

        System.out.println("--- valid payment ---");
        pipeline.handle(new Payment("P1", "Alice", 500, 2_000, false));

        System.out.println("\n--- flagged as fraud ---");
        pipeline.handle(new Payment("P2", "Bob", 300, 5_000, true));

        System.out.println("\n--- insufficient funds ---");
        pipeline.handle(new Payment("P3", "Carol", 5_000, 1_000, false));

        System.out.println("\n--- over auth limit ---");
        pipeline.handle(new Payment("P4", "Dave", 15_000, 50_000, false));

        System.out.println("\n--- large but within limit ---");
        pipeline.handle(new Payment("P5", "Erin", 8_000, 20_000, false));
    }
}
