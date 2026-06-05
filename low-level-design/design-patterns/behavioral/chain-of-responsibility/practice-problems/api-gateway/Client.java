class Client {
    public static void main(String[] args) {
        Handler jwt     = new JwtValidationHandler();
        Handler rate    = new RateLimitingHandler();
        Handler audit   = new AuditLoggingHandler();
        Handler routing = new RoutingHandler();

        jwt.setNext(rate);
        rate.setNext(audit);
        audit.setNext(routing);

        Handler gateway = jwt;   // every request enters at JWT validation

        System.out.println("--- valid request to /users ---");
        gateway.handle(new Request("clientA", "valid-abc", "/users"));

        System.out.println("\n--- valid request to /orders ---");
        gateway.handle(new Request("clientA", "valid-abc", "/orders"));

        System.out.println("\n--- clientA hits rate limit (3rd call) ---");
        gateway.handle(new Request("clientA", "valid-abc", "/users"));

        System.out.println("\n--- bad token ---");
        gateway.handle(new Request("clientB", "expired", "/users"));

        System.out.println("\n--- unknown route ---");
        gateway.handle(new Request("clientC", "valid-xyz", "/payments"));
    }
}
