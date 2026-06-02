public class Client {

    public static void main(String[] args) {

        EmailService emailService = new EmailService();
        ReportService reportService = new ReportService();
        LogService logService = new LogService();

        JobScheduler scheduler = new JobScheduler();

        scheduler.schedule(new SendEmailCommand(emailService, "user@example.us", "Welcome"));
        scheduler.schedule(new GenerateReportCommand(reportService, "DailySales"));
        scheduler.schedule(new CleanupLogsCommand(logService, 30));

        scheduler.run();
    }
}
