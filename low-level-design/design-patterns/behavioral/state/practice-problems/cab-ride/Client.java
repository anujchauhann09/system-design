class Client {
    public static void main(String[] args) {

        System.out.println("--- Happy Path ---");
        Ride ride1 = new Ride("RIDE-001");
        ride1.assignDriver("Ramesh");
        ride1.driverArriving();
        ride1.startRide();
        ride1.completeRide();

        System.out.println("\n--- Cancel before driver assigned ---");
        Ride ride2 = new Ride("RIDE-002");
        ride2.cancelRide();

        System.out.println("\n--- Cancel after driver assigned ---");
        Ride ride3 = new Ride("RIDE-003");
        ride3.assignDriver("Suresh");
        ride3.cancelRide();

        System.out.println("\n--- Cannot cancel in-progress ride ---");
        Ride ride4 = new Ride("RIDE-004");
        ride4.assignDriver("Mahesh");
        ride4.driverArriving();
        ride4.startRide();
        ride4.cancelRide();
        ride4.completeRide();
    }
}
