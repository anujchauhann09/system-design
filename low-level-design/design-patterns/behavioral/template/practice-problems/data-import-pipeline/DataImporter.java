abstract class DataImporter {

    public final void importData() {

        read();

        validate();

        transform();

        store();
    }

    protected abstract void read();

    protected abstract void validate();

    protected abstract void transform();

    private void store() {
        System.out.println("Storing data into database...");
    }
}
