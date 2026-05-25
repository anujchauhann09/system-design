class RideStartedState implements RideState {

    @Override
    public void assignDriver(Ride ride, String driverName) { System.out.println("Ride already in progress."); }

    @Override
    public void driverArriving(Ride ride)   { System.out.println("Ride already in progress."); }

    @Override
    public void startRide(Ride ride)        { System.out.println("Ride already started."); }

    @Override
    public void completeRide(Ride ride) {
        System.out.println("Ride " + ride.getRideId() + " completed. Please rate your driver.");
        ride.setState(new RideCompletedState());
    }

    // Cannot cancel a ride in progress
    @Override
    public void cancelRide(Ride ride) {
        System.out.println("Cannot cancel a ride that is already in progress.");
    }
}
