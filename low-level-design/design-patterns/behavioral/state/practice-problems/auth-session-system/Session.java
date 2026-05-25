class Session {
    private SessionState state;
    private String username;
    private int failedAttempts = 0;
    private static final int MAX_ATTEMPTS = 3;
    private static final String CORRECT_PASSWORD = "secret123";

    Session() {
        this.state = new LoggedOutState();
    }

    void setState(SessionState state)       { this.state = state; }
    String getUsername()                    { return username; }
    void setUsername(String username)       { this.username = username; }
    int getFailedAttempts()                 { return failedAttempts; }
    void incrementFailedAttempts()          { failedAttempts++; }
    void resetFailedAttempts()              { failedAttempts = 0; }
    int getMaxAttempts()                    { return MAX_ATTEMPTS; }
    String getCorrectPassword()             { return CORRECT_PASSWORD; }

    void login(String username, String password) { state.login(this, username, password); }
    void logout()                                { state.logout(this); }
    void expireSession()                         { state.expireSession(this); }
    void lockAccount()                           { state.lockAccount(this); }
}
