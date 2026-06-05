class Client {
    public static void main(String[] args) {
        Handler teamLead = new TeamLeadHandler();
        Handler manager  = new ManagerHandler();
        Handler director = new DirectorHandler();

        teamLead.setNext(manager);
        manager.setNext(director);

        teamLead.handle(new Request("Alice", 1));    // TeamLead
        teamLead.handle(new Request("Bob", 4));      // Manager
        teamLead.handle(new Request("Carol", 8));    // Director
        teamLead.handle(new Request("Dave", 15));    // Rejected
    }
}
