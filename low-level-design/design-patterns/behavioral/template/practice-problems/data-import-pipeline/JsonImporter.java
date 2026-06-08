class JsonImporter extends DataImporter {

    protected void read() {
        System.out.println("Reading JSON file...");
    }

    protected void validate() {
        System.out.println("Validating JSON schema...");
    }

    protected void transform() {
        System.out.println("Transforming JSON objects to records...");
    }
}
