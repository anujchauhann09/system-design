public class Client {

    public static void main(String[] args) {

        Order order = new Order("ORD-1001");
        OrderService service = new OrderService();

        service.process(new PlaceOrderCommand(order));
        service.process(new AssignDeliveryPartnerCommand(order, "Ravi"));

        Order order2 = new Order("ORD-1002");
        service.process(new PlaceOrderCommand(order2));
        service.process(new CancelOrderCommand(order2));
    }
}
