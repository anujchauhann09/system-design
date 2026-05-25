class Client {
    public static void main(String[] args) {

        System.out.println("--- Happy Path ---");
        Session session = new Session();
        session.login("Alice", "secret123");
        session.expireSession();
        session.login("Alice", "secret123");
        session.logout();

        System.out.println("\n--- Wrong password locks account ---");
        Session session2 = new Session();
        session2.login("Bob", "wrong");
        session2.login("Bob", "wrong");
        session2.login("Bob", "wrong");
        session2.login("Bob", "secret123"); // locked, can't login

        System.out.println("\n--- Admin locks active session ---");
        Session session3 = new Session();
        session3.login("Carol", "secret123");
        session3.lockAccount();
        session3.login("Carol", "secret123"); // locked
    }
}
