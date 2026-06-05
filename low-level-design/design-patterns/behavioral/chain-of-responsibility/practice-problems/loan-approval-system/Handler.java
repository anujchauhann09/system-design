abstract class Handler {

    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    // pass the application down the chain, if there is a next link
    protected void forward(LoanApplication application) {
        if (next != null) {
            next.handle(application);
        }
    }

    public abstract void handle(LoanApplication application);
}
