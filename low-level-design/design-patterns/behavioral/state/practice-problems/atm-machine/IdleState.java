class IdleState implements ATMState {

    @Override
    public void insertCard(ATM atm) {
        System.out.println("Card inserted. Please enter PIN.");
        atm.setState(new CardInsertedState());
    }

    @Override
    public void enterPin(ATM atm, int pin) {
        System.out.println("Please insert card first.");
    }

    @Override
    public void withdraw(ATM atm, double amount) {
        System.out.println("Please insert card first.");
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("No card to eject.");
    }
}
