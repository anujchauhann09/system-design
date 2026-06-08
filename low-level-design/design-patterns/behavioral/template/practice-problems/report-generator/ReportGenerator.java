abstract class ReportGenerator {

    public final void generateReport() {

        loadData();

        processData();

        exportReport();

        sendReport();
    }

    protected abstract void processData();

    private void loadData() {
        System.out.println("Loading Data...");
    }

    private void exportReport() {
        System.out.println("Exporting  Data...");
    }

    private void sendReport() {
        System.out.println("Sending Data...");
    }
}