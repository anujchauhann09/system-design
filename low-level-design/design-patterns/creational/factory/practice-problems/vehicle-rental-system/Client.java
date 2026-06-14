class Client {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();

        factory.createVehicle("bike").rent();    
        factory.createVehicle("car").rent();     
        factory.createVehicle("truck").rent();  
    }
}
