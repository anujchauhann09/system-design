class XmlImporter extends DataImporter {

    protected void read() {
        System.out.println("Reading XML file...");
    }

    protected void validate() {
        System.out.println("Validating XML against DTD...");
    }

    protected void transform() {
        System.out.println("Transforming XML nodes to records...");
    }
}
