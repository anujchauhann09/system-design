public class Application {

    private Chair chair;
    private Table table;

    public Application(FurnitureFactory factory) {

        this.chair =
                factory.createChair();

        this.table =
                factory.createTable();
    }

    public void render() {
        chair.render();
        table.render();
    }

    public static void main(String[] args) {

        // pick a family once. Swap this single line to switch
        // the entire furniture set — no other code changes
        FurnitureFactory factory =
                new ModernFurnitureFactory();

        Application app =
                new Application(factory);

        app.render();   // Modern Chair / Modern Table
    }
}
