class JwtValidationHandler extends Handler {

    @Override
    public void handle(Request request) {
        String jwt = request.getJwt();
        if (jwt == null || !jwt.startsWith("valid-")) {
            System.out.println("[401] " + request.getClientId() + " - invalid or missing JWT");
            return;   // short-circuit the chain
        }
        System.out.println("[JWT] verified for " + request.getClientId());
        forward(request);
    }
}
