class Ticket {

    private final String customer;
    private final int severity;   // 1 = basic, 2 = advanced, 3 = critical

    public Ticket(String customer, int severity) {
        this.customer = customer;
        this.severity = severity;
    }

    public String getCustomer() {
        return customer;
    }

    public int getSeverity() {
        return severity;
    }
}
