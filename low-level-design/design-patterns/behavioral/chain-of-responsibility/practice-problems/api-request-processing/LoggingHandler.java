class LoggingHandler extends Handler {

    @Override
    public void handle(Request request) {
        System.out.println("[Log] " + request.getEndpoint() + " processed for role '"
                + request.getRole() + "'");
        System.out.println("[200] " + request.getEndpoint() + " - OK");
        forward(request);   // end of chain (next == null), but stays extensible
    }
}
