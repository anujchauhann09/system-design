public class Client {

    public static void main(String args[]) {

        DataImporter csv = new CsvImporter();
        csv.importData();

        System.out.println();

        DataImporter json = new JsonImporter();
        json.importData();

        System.out.println();

        DataImporter xml = new XmlImporter();
        xml.importData();
    }
}
