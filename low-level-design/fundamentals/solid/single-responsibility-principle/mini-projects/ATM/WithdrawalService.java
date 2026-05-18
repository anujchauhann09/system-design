class WithdrawalService {

    void withdrawMoney(BankAccount account, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        if (amount > account.balance) {
            System.out.println("Insufficient balance.");
            return;
        }
        account.balance -= amount;
        System.out.println("Withdrawn: " + amount + " | Balance: " + account.balance);
    }
}
