class Level3Handler extends Handler {

    private static final int LEVEL = 3;

    @Override
    public void handle(Ticket ticket) {
        if (ticket.getSeverity() <= LEVEL) {
            System.out.println("Level3 resolved ticket for " + ticket.getCustomer()
                    + " (severity " + ticket.getSeverity() + ")");
        } else if (next != null) {
            next.handle(ticket);
        } else {
            System.out.println("Ticket for " + ticket.getCustomer() + " could not be resolved");
        }
    }
}
