abstract class ETLEngine {

    public final void run() {

        extract();

        transform();

        load();

        audit();
    }

    protected abstract void transform();

    private void extract() {
        System.out.println("Extracting raw data from source...");
    }

    private void load() {
        System.out.println("Loading data into warehouse...");
    }

    private void audit() {
        System.out.println("Auditing ETL run...");
    }
}
