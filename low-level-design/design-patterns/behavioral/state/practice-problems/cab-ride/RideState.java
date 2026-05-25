interface RideState {
    void assignDriver(Ride ride, String driverName);
    void driverArriving(Ride ride);
    void startRide(Ride ride);
    void completeRide(Ride ride);
    void cancelRide(Ride ride);
}
