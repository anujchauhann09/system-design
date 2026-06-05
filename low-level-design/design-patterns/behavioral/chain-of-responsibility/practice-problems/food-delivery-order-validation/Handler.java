abstract class Handler {

    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    // pass the order down the chain, if there is a next link
    protected void forward(Order order) {
        if (next != null) {
            next.handle(order);
        }
    }

    public abstract void handle(Order order);
}
