class Transaction {
    String userId;
    double amount;
    String location;
    int transactionsInLastHour;

    Transaction(String userId, double amount, String location, int transactionsInLastHour) {
        this.userId = userId;
        this.amount = amount;
        this.location = location;
        this.transactionsInLastHour = transactionsInLastHour;
    }
}
