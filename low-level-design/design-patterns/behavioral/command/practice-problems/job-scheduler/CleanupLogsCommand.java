class CleanupLogsCommand implements Command {
    private LogService logService;
    private int olderThanDays;

    public CleanupLogsCommand(LogService logService, int olderThanDays) {
        this.logService = logService;
        this.olderThanDays = olderThanDays;
    }

    public void execute() {
        logService.cleanup(olderThanDays);
    }
}
