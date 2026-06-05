abstract class Handler {

    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    // pass the payment down the chain, if there is a next link
    protected void forward(Payment payment) {
        if (next != null) {
            next.handle(payment);
        }
    }

    public abstract void handle(Payment payment);
}
