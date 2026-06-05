class Request {

    private final String endpoint;
    private final String token;   // null/empty = not authenticated
    private final String role;    // e.g. "user", "admin"
    private final String body;    // null/empty = invalid payload

    public Request(String endpoint, String token, String role, String body) {
        this.endpoint = endpoint;
        this.token = token;
        this.role = role;
        this.body = body;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getToken() {
        return token;
    }

    public String getRole() {
        return role;
    }

    public String getBody() {
        return body;
    }
}
