class CashDispensingState implements ATMState {

    @Override
    public void insertCard(ATM atm) {
        System.out.println("Please collect your cash first.");
    }

    @Override
    public void enterPin(ATM atm, int pin) {
        System.out.println("Please collect your cash first.");
    }

    @Override
    public void withdraw(ATM atm, double amount) {
        System.out.println("Please collect your cash first.");
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Cash dispensed. Card ejected. Thank you!");
        atm.setState(new IdleState());
    }
}
