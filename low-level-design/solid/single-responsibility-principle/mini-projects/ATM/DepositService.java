class DepositService {

    void depositMoney(BankAccount account, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }
        account.balance += amount;
        System.out.println("Deposited: " + amount + " | Balance: " + account.balance);
    }
}
