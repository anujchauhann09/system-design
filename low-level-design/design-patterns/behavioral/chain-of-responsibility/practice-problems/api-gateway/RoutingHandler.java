class RoutingHandler extends Handler {

    @Override
    public void handle(Request request) {
        String service = backendFor(request.getPath());
        if (service == null) {
            System.out.println("[404] no route for " + request.getPath());
            return;
        }
        System.out.println("[200] routed " + request.getPath() + " -> " + service);
        forward(request);   // end of chain, but stays extensible
    }

    private String backendFor(String path) {
        if (path.startsWith("/users"))  return "user-service";
        if (path.startsWith("/orders")) return "order-service";
        return null;
    }
}
