class CsvImporter extends DataImporter {

    protected void read() {
        System.out.println("Reading CSV file...");
    }

    protected void validate() {
        System.out.println("Validating CSV columns...");
    }

    protected void transform() {
        System.out.println("Transforming CSV rows to records...");
    }
}
