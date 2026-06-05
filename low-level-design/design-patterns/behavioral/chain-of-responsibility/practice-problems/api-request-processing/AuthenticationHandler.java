class AuthenticationHandler extends Handler {

    @Override
    public void handle(Request request) {
        if (request.getToken() == null || request.getToken().isEmpty()) {
            System.out.println("[401] " + request.getEndpoint() + " - authentication failed: missing token");
            return;   // short-circuit the chain
        }
        System.out.println("[Auth] token accepted");
        forward(request);
    }
}
