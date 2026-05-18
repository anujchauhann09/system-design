class Car {
    String model;
    Engine engine;

    Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    void drive() {
        engine.start();
        System.out.println(model + " is driving...");
    }
}
