class Payment {

    private final String id;
    private final String payer;
    private final double amount;
    private final double accountBalance;
    private final boolean suspicious;

    public Payment(String id, String payer, double amount,
                   double accountBalance, boolean suspicious) {
        this.id = id;
        this.payer = payer;
        this.amount = amount;
        this.accountBalance = accountBalance;
        this.suspicious = suspicious;
    }

    public String getId() {
        return id;
    }

    public String getPayer() {
        return payer;
    }

    public double getAmount() {
        return amount;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public boolean isSuspicious() {
        return suspicious;
    }
}
