class Client {
    public static void main(String[] args) {

        System.out.println("--- Happy Path ---");
        Order order1 = new Order("ORD-001");
        order1.pay(1500);
        order1.pack();
        order1.ship();
        order1.deliver();
        order1.returnOrder();

        System.out.println("\n--- Cancel after placing ---");
        Order order2 = new Order("ORD-002");
        order2.cancel();

        System.out.println("\n--- Cannot cancel delivered order ---");
        Order order3 = new Order("ORD-003");
        order3.pay(500);
        order3.pack();
        order3.ship();
        order3.deliver();
        order3.cancel();

        System.out.println("\n--- Cannot ship cancelled order ---");
        Order order4 = new Order("ORD-004");
        order4.cancel();
        order4.ship();
    }
}
