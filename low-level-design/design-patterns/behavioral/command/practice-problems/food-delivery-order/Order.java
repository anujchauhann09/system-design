class Order {

    private String id;
    private String status = "NEW";
    private String deliveryPartner;

    public Order(String id) {
        this.id = id;
    }

    public void place() {
        status = "PLACED";
        System.out.println("Order " + id + " placed");
    }

    public void cancel() {
        status = "CANCELLED";
        System.out.println("Order " + id + " cancelled");
    }

    public void assignDeliveryPartner(String partner) {
        this.deliveryPartner = partner;
        status = "OUT_FOR_DELIVERY";
        System.out.println("Order " + id + " assigned to " + partner);
    }

    public String getStatus() {
        return status;
    }
}
