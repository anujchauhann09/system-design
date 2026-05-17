class ElectricCar implements Drivable, Rechargeable {

    @Override
    public void drive() {
        System.out.println("ElectricCar: driving...");
    }

    @Override
    public void recharge() {
        System.out.println("ElectricCar: recharging...");
    }
}
