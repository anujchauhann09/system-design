abstract class PaymentProcessor {

    public final void pay() {

        validate();

        process();

        notifyUser();
    }

    protected abstract void process();

    private void validate() {
        System.out.println("Validating payment details...");
    }

    private void notifyUser() {
        System.out.println("Notifying user...");
    }
}
