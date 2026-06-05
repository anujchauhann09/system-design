class Client {
    public static void main(String[] args) {
        Handler supervisor  = new SupervisorHandler();
        Handler manager     = new ManagerHandler();
        Handler financeHead = new FinanceHeadHandler();

        supervisor.setNext(manager);
        manager.setNext(financeHead);

        Handler chain = supervisor;   // head of the chain

        chain.handle(new ExpenseRequest("Alice", 800));      // Supervisor
        chain.handle(new ExpenseRequest("Bob", 4_500));      // Manager
        chain.handle(new ExpenseRequest("Carol", 15_000));   // Finance Head
        chain.handle(new ExpenseRequest("Dave", 50_000));    // Rejected
    }
}
