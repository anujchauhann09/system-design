class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        if(balance < 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public void deposit(double amount) {

        if(amount <= 0) {
            System.out.println("Invalid amount");
            return;
        }

        this.balance += amount;
    }

    public void withdraw(double amount) {

        if(amount <= 0) {
            System.out.println("Invalid amount");
            return;
        }
        else if(amount > this.balance) {
            System.out.println("Insufficient funds");
            return;
        }

        this.balance -= amount;
    }

    public double getBalance() {
        return this.balance;
    }
}