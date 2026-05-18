class ATMService {

    DepositService depositService = new DepositService();
    WithdrawalService withdrawalService = new WithdrawalService();

    void deposit(BankAccount account, double amount) {
        depositService.depositMoney(account, amount);
    }

    void withdraw(BankAccount account, double amount) {
        withdrawalService.withdrawMoney(account, amount);
    }
}
