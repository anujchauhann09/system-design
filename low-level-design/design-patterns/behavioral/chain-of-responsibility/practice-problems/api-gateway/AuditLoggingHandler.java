class AuditLoggingHandler extends Handler {

    @Override
    public void handle(Request request) {
        // audit logging never rejects - it records and passes on
        System.out.println("[Audit] " + request.getClientId() + " -> " + request.getPath());
        forward(request);
    }
}
