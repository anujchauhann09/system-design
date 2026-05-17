class FlyingCar implements Drivable, Flyable, Refuelable {

    @Override
    public void drive() {
        System.out.println("FlyingCar: driving...");
    }

    @Override
    public void fly() {
        System.out.println("FlyingCar: flying...");
    }

    @Override
    public void refuel() {
        System.out.println("FlyingCar: refueling...");
    }
}
