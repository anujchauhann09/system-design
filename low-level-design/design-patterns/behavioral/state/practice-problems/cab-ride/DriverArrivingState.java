class DriverArrivingState implements RideState {

    @Override
    public void assignDriver(Ride ride, String driverName) { System.out.println("Driver already assigned."); }

    @Override
    public void driverArriving(Ride ride)   { System.out.println("Driver is already on the way."); }

    @Override
    public void startRide(Ride ride) {
        System.out.println("Ride " + ride.getRideId() + " started with driver " + ride.getDriverName());
        ride.setState(new RideStartedState());
    }

    @Override
    public void completeRide(Ride ride)     { System.out.println("Ride not started yet."); }

    @Override
    public void cancelRide(Ride ride) {
        System.out.println("Ride " + ride.getRideId() + " cancelled while driver was arriving.");
        ride.setState(new CancelledState());
    }
}
