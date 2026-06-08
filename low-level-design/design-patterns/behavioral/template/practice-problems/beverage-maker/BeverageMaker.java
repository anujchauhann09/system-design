abstract class BeverageMaker {

    public final void prepareBeverage() {

        boilWater();

        addIngredient();

        pour();

        serve();
    }

    protected abstract void addIngredient();

    private void boilWater() {
        System.out.println("Boiling water...");
    }

    private void pour() {
        System.out.println("Pouring into cup...");
    }

    private void serve() {
        System.out.println("Serving the beverage...");
    }
}
