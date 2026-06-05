class Request {

    private final String clientId;
    private final String jwt;     // null/empty or not "valid-*" = unauthenticated
    private final String path;    // e.g. "/users", "/orders"

    public Request(String clientId, String jwt, String path) {
        this.clientId = clientId;
        this.jwt = jwt;
        this.path = path;
    }

    public String getClientId() {
        return clientId;
    }

    public String getJwt() {
        return jwt;
    }

    public String getPath() {
        return path;
    }
}
