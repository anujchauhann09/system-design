public class ZomatoFactory
        implements PartnerFactory {

    @Override
    public OrderService createOrderService() {
        return new ZomatoOrderService();
    }

    @Override
    public PaymentService createPaymentService() {
        return new ZomatoPaymentService();
    }

    @Override
    public DeliveryService createDeliveryService() {
        return new ZomatoDeliveryService();
    }
}
