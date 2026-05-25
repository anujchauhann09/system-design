class CardInsertedState implements ATMState {

    @Override
    public void insertCard(ATM atm) {
        System.out.println("Card already inserted.");
    }

    @Override
    public void enterPin(ATM atm, int pin) {
        if (pin == atm.getCorrectPin()) {
            System.out.println("PIN correct. Select transaction.");
            atm.setState(new PinEnteredState());
        } else {
            System.out.println("Wrong PIN. Card ejected.");
            atm.setState(new IdleState());
        }
    }

    @Override
    public void withdraw(ATM atm, double amount) {
        System.out.println("Please enter PIN first.");
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Card ejected.");
        atm.setState(new IdleState());
    }
}
