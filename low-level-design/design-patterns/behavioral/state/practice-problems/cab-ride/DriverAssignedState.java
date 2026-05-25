class DriverAssignedState implements RideState {

    @Override
    public void assignDriver(Ride ride, String driverName) { System.out.println("Driver already assigned."); }

    @Override
    public void driverArriving(Ride ride) {
        System.out.println("Driver " + ride.getDriverName() + " is arriving for ride " + ride.getRideId());
        ride.setState(new DriverArrivingState());
    }

    @Override
    public void startRide(Ride ride)    { System.out.println("Wait for driver to arrive first."); }

    @Override
    public void completeRide(Ride ride) { System.out.println("Ride not started yet."); }

    @Override
    public void cancelRide(Ride ride) {
        System.out.println("Ride " + ride.getRideId() + " cancelled after driver assignment.");
        ride.setState(new CancelledState());
    }
}
