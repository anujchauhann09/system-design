class BankAccount {
    int accountNumber;
    float balance;

    void deposit(float amount) {
        if(amount <= 0) {
            System.out.println("Enter amount more than 0.");
            return;
        }

        balance += amount;
        System.out.println("Amount deposited.");
    }

    void withdraw(float amount) {
        if(amount > balance) {
            System.out.println("Amount is greater than balance.");
            return;
        }

        balance -= amount;
        System.out.println("Amount withdrawn.");
    }
}