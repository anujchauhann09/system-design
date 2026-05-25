class Client {
    public static void main(String[] args) {

        System.out.println("--- Happy Path ---");
        Payment p1 = new Payment("PAY-001", 1500);
        p1.authorize();
        p1.capture();
        p1.refund();

        System.out.println("\n--- Authorization failure ---");
        Payment p2 = new Payment("PAY-002", 500);
        p2.fail("Insufficient funds");
        p2.capture(); // blocked

        System.out.println("\n--- Capture failure ---");
        Payment p3 = new Payment("PAY-003", 2000);
        p3.authorize();
        p3.fail("Bank timeout");

        System.out.println("\n--- Chargeback ---");
        Payment p4 = new Payment("PAY-004", 3000);
        p4.authorize();
        p4.capture();
        p4.chargeback();
        p4.refund(); // blocked — chargeback already raised
    }
}
