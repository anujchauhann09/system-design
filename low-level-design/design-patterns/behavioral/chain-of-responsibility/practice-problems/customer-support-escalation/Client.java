class Client {
    public static void main(String[] args) {
        Handler level1 = new Level1Handler();
        Handler level2 = new Level2Handler();
        Handler level3 = new Level3Handler();

        level1.setNext(level2);
        level2.setNext(level3);

        Handler chain = level1;   // tickets always enter at Level1

        chain.handle(new Ticket("Alice", 1));   // Level1
        chain.handle(new Ticket("Bob", 2));     // Level2
        chain.handle(new Ticket("Carol", 3));   // Level3
        chain.handle(new Ticket("Dave", 4));    // Unresolved
    }
}
