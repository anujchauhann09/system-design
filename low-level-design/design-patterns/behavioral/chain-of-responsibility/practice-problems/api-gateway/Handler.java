abstract class Handler {

    protected Handler next;

    public void setNext(Handler next) {
        this.next = next;
    }

    // pass the request down the chain, if there is a next link
    protected void forward(Request request) {
        if (next != null) {
            next.handle(request);
        }
    }

    public abstract void handle(Request request);
}
