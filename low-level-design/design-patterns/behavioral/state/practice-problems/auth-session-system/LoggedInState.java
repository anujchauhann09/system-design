class LoggedInState implements SessionState {

    @Override
    public void login(Session session, String username, String password) {
        System.out.println("Already logged in as " + session.getUsername() + ".");
    }

    @Override
    public void logout(Session session) {
        System.out.println(session.getUsername() + " logged out.");
        session.setState(new LoggedOutState());
    }

    @Override
    public void expireSession(Session session) {
        System.out.println("Session expired for " + session.getUsername() + ". Please login again.");
        session.setState(new SessionExpiredState());
    }

    @Override
    public void lockAccount(Session session) {
        System.out.println("Account locked for " + session.getUsername() + ".");
        session.setState(new LockedState());
    }
}
