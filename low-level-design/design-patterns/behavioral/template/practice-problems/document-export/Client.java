public class Client {

    public static void main(String args[]) {

        DocumentExporter pdf = new PdfExporter();
        pdf.export();

        System.out.println();

        DocumentExporter csv = new CsvExporter();
        csv.export();

        System.out.println();

        DocumentExporter excel = new ExcelExporter();
        excel.export();
    }
}
