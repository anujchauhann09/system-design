class VehicleFactory {
    public Vehicle createVehicle(String type) {

        switch (type.toLowerCase()) {
            case "bike":
                return new Bike();
            case "car": 
                return new Car();
            case "truck":
                return new Truck();
            default:
                throw new IllegalArgumentException("Unknown vehicle: " + type);
        }
    }
}
