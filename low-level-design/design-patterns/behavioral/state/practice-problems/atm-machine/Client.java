class Client {
    public static void main(String[] args) {
        ATM atm = new ATM(5000);

        System.out.println("--- Happy Path ---");
        atm.insertCard();
        atm.enterPin(1234);
        atm.withdraw(1000);
        atm.ejectCard();

        System.out.println("\n--- Wrong PIN ---");
        atm.insertCard();
        atm.enterPin(9999);

        System.out.println("\n--- Cancel Transaction ---");
        atm.insertCard();
        atm.enterPin(1234);
        atm.ejectCard();

        System.out.println("\n--- Insufficient ATM Cash ---");
        atm.insertCard();
        atm.enterPin(1234);
        atm.withdraw(9999);
    }
}
