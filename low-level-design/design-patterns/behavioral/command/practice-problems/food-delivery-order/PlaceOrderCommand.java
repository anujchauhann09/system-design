class PlaceOrderCommand implements Command {
    private Order order;

    public PlaceOrderCommand(Order order) {
        this.order = order;
    }

    public void execute() {
        order.place();
    }
}
