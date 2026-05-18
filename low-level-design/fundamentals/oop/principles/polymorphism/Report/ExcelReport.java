class ExcelReport implements ReportGenerator {
    @Override
    public void generateReport(String data) {
        System.out.println("Generating Excel report: " + data);
    }
}
