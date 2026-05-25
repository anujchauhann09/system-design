interface SessionState {
    void login(Session session, String username, String password);
    void logout(Session session);
    void expireSession(Session session);
    void lockAccount(Session session);
}
