class GenerateReportCommand implements Command {
    private ReportService reportService;
    private String reportName;

    public GenerateReportCommand(ReportService reportService, String reportName) {
        this.reportService = reportService;
        this.reportName = reportName;
    }

    public void execute() {
        reportService.generate(reportName);
    }
}
