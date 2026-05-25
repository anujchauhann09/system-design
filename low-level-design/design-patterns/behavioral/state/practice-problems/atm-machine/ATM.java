class ATM {
    private ATMState state;
    private double cashAvailable;
    private int correctPin = 1234;

    ATM(double cashAvailable) {
        this.cashAvailable = cashAvailable;
        this.state = new IdleState();
    }

    void setState(ATMState state)       { this.state = state; }
    double getCashAvailable()           { return cashAvailable; }
    void setCashAvailable(double cash)  { this.cashAvailable = cash; }
    int getCorrectPin()                 { return correctPin; }

    void insertCard()               { state.insertCard(this); }
    void enterPin(int pin)          { state.enterPin(this, pin); }
    void withdraw(double amount)    { state.withdraw(this, amount); }
    void ejectCard()                { state.ejectCard(this); }
}
