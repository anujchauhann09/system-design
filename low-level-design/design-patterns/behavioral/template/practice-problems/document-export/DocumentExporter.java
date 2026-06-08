abstract class DocumentExporter {

    public final void export() {

        load();

        format();

        save();
    }

    protected abstract void format();

    private void load() {
        System.out.println("Loading document data...");
    }

    private void save() {
        System.out.println("Exporting to file...");
    }
}
