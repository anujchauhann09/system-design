class PdfReport implements ReportGenerator {
    @Override
    public void generateReport(String data) {
        System.out.println("Generating PDF report: " + data);
    }
}
