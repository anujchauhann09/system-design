class Request {

    private final String employee;
    private final int days;

    public Request(String employee, int days) {
        this.employee = employee;
        this.days = days;
    }

    public String getEmployee() {
        return employee;
    }

    public int getDays() {
        return days;
    }
}
