class RideCompletedState implements RideState {

    @Override
    public void assignDriver(Ride ride, String driverName) { System.out.println("Ride already completed."); }

    @Override
    public void driverArriving(Ride ride)   { System.out.println("Ride already completed."); }

    @Override
    public void startRide(Ride ride)        { System.out.println("Ride already completed."); }

    @Override
    public void completeRide(Ride ride)     { System.out.println("Ride already completed."); }

    @Override
    public void cancelRide(Ride ride)       { System.out.println("Cannot cancel a completed ride."); }
}
