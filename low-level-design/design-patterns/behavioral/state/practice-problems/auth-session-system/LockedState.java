class LockedState implements SessionState {

    @Override
    public void login(Session session, String username, String password) {
        System.out.println("Account is locked. Contact support to unlock.");
    }

    @Override
    public void logout(Session session)         { System.out.println("Account is locked."); }

    @Override
    public void expireSession(Session session)  { System.out.println("Account is locked."); }

    @Override
    public void lockAccount(Session session)    { System.out.println("Account already locked."); }
}
