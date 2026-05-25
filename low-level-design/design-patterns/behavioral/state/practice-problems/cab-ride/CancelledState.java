class CancelledState implements RideState {

    @Override
    public void assignDriver(Ride ride, String driverName) { System.out.println("Ride is cancelled."); }

    @Override
    public void driverArriving(Ride ride)   { System.out.println("Ride is cancelled."); }

    @Override
    public void startRide(Ride ride)        { System.out.println("Ride is cancelled."); }

    @Override
    public void completeRide(Ride ride)     { System.out.println("Ride is cancelled."); }

    @Override
    public void cancelRide(Ride ride)       { System.out.println("Ride already cancelled."); }
}
