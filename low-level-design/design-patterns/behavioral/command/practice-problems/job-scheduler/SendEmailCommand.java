class SendEmailCommand implements Command {
    private EmailService emailService;
    private String to;
    private String subject;

    public SendEmailCommand(EmailService emailService, String to, String subject) {
        this.emailService = emailService;
        this.to = to;
        this.subject = subject;
    }

    public void execute() {
        emailService.send(to, subject);
    }
}
