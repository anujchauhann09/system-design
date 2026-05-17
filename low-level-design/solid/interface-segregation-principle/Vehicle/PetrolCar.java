class PetrolCar implements Drivable, Refuelable {

    @Override
    public void drive() {
        System.out.println("PetrolCar: driving...");
    }

    @Override
    public void refuel() {
        System.out.println("PetrolCar: refueling...");
    }
}
