class Bird {
    String name;
    FlyBehavior flyBehavior;

    Bird(String name, FlyBehavior flyBehavior) {
        this.name = name;
        this.flyBehavior = flyBehavior;
    }

    void fly() {
        flyBehavior.fly();
    }
}
