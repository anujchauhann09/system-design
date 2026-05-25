class RequestedState implements RideState {

    @Override
    public void assignDriver(Ride ride, String driverName) {
        ride.setDriverName(driverName);
        System.out.println("Driver " + driverName + " assigned to ride " + ride.getRideId());
        ride.setState(new DriverAssignedState());
    }

    @Override
    public void driverArriving(Ride ride)   { System.out.println("No driver assigned yet."); }

    @Override
    public void startRide(Ride ride)        { System.out.println("Driver not assigned yet."); }

    @Override
    public void completeRide(Ride ride)     { System.out.println("Ride not started yet."); }

    @Override
    public void cancelRide(Ride ride) {
        System.out.println("Ride " + ride.getRideId() + " cancelled before driver assignment.");
        ride.setState(new CancelledState());
    }
}
