public class SwiggyFactory
        implements PartnerFactory {

    @Override
    public OrderService createOrderService() {
        return new SwiggyOrderService();
    }

    @Override
    public PaymentService createPaymentService() {
        return new SwiggyPaymentService();
    }

    @Override
    public DeliveryService createDeliveryService() {
        return new SwiggyDeliveryService();
    }
}
