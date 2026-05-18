class Client {
    public static void main(String[] args) {
        CabService normal = new CabService(new NormalFare());
        CabService surge = new CabService(new SurgeFare(1.5));
        CabService premium = new CabService(new PremiumFare());

        System.out.println("Normal fare: " + normal.getFare(10));    // 100.0
        System.out.println("Surge fare: " + surge.getFare(10));      // 150.0
        System.out.println("Premium fare: " + premium.getFare(10));  // 200.0
    }
}
