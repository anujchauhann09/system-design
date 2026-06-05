class ExpenseRequest {

    private final String requester;
    private final double amount;

    public ExpenseRequest(String requester, double amount) {
        this.requester = requester;
        this.amount = amount;
    }

    public String getRequester() {
        return requester;
    }

    public double getAmount() {
        return amount;
    }
}
