class AssignDeliveryPartnerCommand implements Command {
    private Order order;
    private String partner;

    public AssignDeliveryPartnerCommand(Order order, String partner) {
        this.order = order;
        this.partner = partner;
    }

    public void execute() {
        order.assignDeliveryPartner(partner);
    }
}
