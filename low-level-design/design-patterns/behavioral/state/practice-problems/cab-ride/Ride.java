class Ride {
    private RideState state;
    private String rideId;
    private String driverName;

    Ride(String rideId) {
        this.rideId = rideId;
        this.state = new RequestedState();
        System.out.println("Ride " + rideId + " requested.");
    }

    void setState(RideState state)          { this.state = state; }
    String getRideId()                      { return rideId; }
    String getDriverName()                  { return driverName; }
    void setDriverName(String driverName)   { this.driverName = driverName; }

    void assignDriver(String driverName)    { state.assignDriver(this, driverName); }
    void driverArriving()                   { state.driverArriving(this); }
    void startRide()                        { state.startRide(this); }
    void completeRide()                     { state.completeRide(this); }
    void cancelRide()                       { state.cancelRide(this); }
}
