class Client {
    public static void main(String[] args) {
        Handler auth       = new AuthenticationHandler();
        Handler authz      = new AuthorizationHandler();
        Handler validation = new ValidationHandler();
        Handler logging    = new LoggingHandler();

        auth.setNext(authz);
        authz.setNext(validation);
        validation.setNext(logging);

        Handler chain = auth;   // every request enters at authentication

        System.out.println("--- valid admin request ---");
        chain.handle(new Request("/orders", "tok-123", "admin", "{ id: 1 }"));

        System.out.println("\n--- missing token ---");
        chain.handle(new Request("/orders", "", "admin", "{ id: 1 }"));

        System.out.println("\n--- wrong role ---");
        chain.handle(new Request("/orders", "tok-123", "user", "{ id: 1 }"));

        System.out.println("\n--- empty body ---");
        chain.handle(new Request("/orders", "tok-123", "admin", ""));
    }
}
