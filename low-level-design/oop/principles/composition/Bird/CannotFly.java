class CannotFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("This bird cannot fly.");
    }
}
