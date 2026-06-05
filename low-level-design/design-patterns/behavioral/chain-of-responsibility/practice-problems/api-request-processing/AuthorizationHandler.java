class AuthorizationHandler extends Handler {

    @Override
    public void handle(Request request) {
        if (!"admin".equals(request.getRole())) {
            System.out.println("[403] " + request.getEndpoint() + " - authorization failed: role '"
                    + request.getRole() + "' not allowed");
            return;   // short-circuit the chain
        }
        System.out.println("[Authz] role '" + request.getRole() + "' permitted");
        forward(request);
    }
}
