class PinEnteredState implements ATMState {

    @Override
    public void insertCard(ATM atm) {
        System.out.println("Card already inserted.");
    }

    @Override
    public void enterPin(ATM atm, int pin) {
        System.out.println("PIN already entered.");
    }

    @Override
    public void withdraw(ATM atm, double amount) {
        if (atm.getCashAvailable() <= 0) {
            System.out.println("ATM out of cash. Card ejected.");
            atm.setState(new IdleState());
            return;
        }
        if (amount > atm.getCashAvailable()) {
            System.out.println("Insufficient cash in ATM. Card ejected.");
            atm.setState(new IdleState());
            return;
        }
        System.out.println("Dispensing ₹" + amount + "...");
        atm.setCashAvailable(atm.getCashAvailable() - amount);
        atm.setState(new CashDispensingState());
    }

    @Override
    public void ejectCard(ATM atm) {
        System.out.println("Transaction cancelled. Card ejected.");
        atm.setState(new IdleState());
    }
}
