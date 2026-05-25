class LoggedOutState implements SessionState {

    @Override
    public void login(Session session, String username, String password) {
        if (password.equals(session.getCorrectPassword())) {
            session.setUsername(username);
            session.resetFailedAttempts();
            System.out.println(username + " logged in successfully.");
            session.setState(new LoggedInState());
        } else {
            session.incrementFailedAttempts();
            System.out.println("Wrong password. Attempt " + session.getFailedAttempts() + "/" + session.getMaxAttempts());
            if (session.getFailedAttempts() >= session.getMaxAttempts()) {
                System.out.println("Too many failed attempts. Account locked.");
                session.setState(new LockedState());
            }
        }
    }

    @Override
    public void logout(Session session)         { System.out.println("Already logged out."); }

    @Override
    public void expireSession(Session session)  { System.out.println("No active session to expire."); }

    @Override
    public void lockAccount(Session session) {
        System.out.println("Account locked.");
        session.setState(new LockedState());
    }
}
