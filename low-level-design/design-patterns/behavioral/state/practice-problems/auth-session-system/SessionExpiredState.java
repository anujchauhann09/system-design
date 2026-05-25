class SessionExpiredState implements SessionState {

    @Override
    public void login(Session session, String username, String password) {
        if (password.equals(session.getCorrectPassword())) {
            session.setUsername(username);
            System.out.println("Session renewed. " + username + " logged in.");
            session.setState(new LoggedInState());
        } else {
            System.out.println("Wrong password.");
        }
    }

    @Override
    public void logout(Session session) {
        System.out.println("Session already expired. Redirecting to login.");
        session.setState(new LoggedOutState());
    }

    @Override
    public void expireSession(Session session)  { System.out.println("Session already expired."); }

    @Override
    public void lockAccount(Session session) {
        System.out.println("Account locked.");
        session.setState(new LockedState());
    }
}
