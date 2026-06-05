class InventoryAvailableHandler extends Handler {

    @Override
    public void handle(Order order) {
        if (!order.isInventoryAvailable()) {
            System.out.println("Order " + order.getId() + " rejected: items out of stock");
            return;   // short-circuit the chain
        }
        System.out.println("[OK] inventory reserved");
        System.out.println("Order " + order.getId() + " confirmed!");
        forward(order);   // end of chain, but stays extensible
    }
}
