public class Application {

    private OrderService orderService;
    private PaymentService paymentService;
    private DeliveryService deliveryService;

    public Application(PartnerFactory factory) {

        this.orderService =
                factory.createOrderService();

        this.paymentService =
                factory.createPaymentService();

        this.deliveryService =
                factory.createDeliveryService();
    }

    public void orderFood(String item, double amount, String address) {
        orderService.placeOrder(item);
        paymentService.pay(amount);
        deliveryService.deliver(address);
    }

    public static void main(String[] args) {

        // pick a delivery partner once. Swap this single line to switch
        // the entire ecosystem (Order + Payment + Delivery) — no other
        // code changes. Never mix Swiggy orders with Zomato delivery
        PartnerFactory factory =
                new SwiggyFactory();

        Application app =
                new Application(factory);

        app.orderFood("Paneer Tikka", 350.0, "221B Baker Street");
    }
}
