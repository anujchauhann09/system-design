interface ATMState {
    void insertCard(ATM atm);
    void enterPin(ATM atm, int pin);
    void withdraw(ATM atm, double amount);
    void ejectCard(ATM atm);
}
