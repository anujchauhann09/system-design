class ValidationHandler extends Handler {

    @Override
    public void handle(Request request) {
        if (request.getBody() == null || request.getBody().isEmpty()) {
            System.out.println("[400] " + request.getEndpoint() + " - validation failed: empty body");
            return;   // short-circuit the chain
        }
        System.out.println("[Validation] body looks good");
        forward(request);
    }
}
