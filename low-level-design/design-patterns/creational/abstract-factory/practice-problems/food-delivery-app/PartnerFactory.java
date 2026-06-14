// abstract Factory: returns a COMPLETE partner ecosystem
// (Order + Payment + Delivery) all from the same integration
public interface PartnerFactory {

    OrderService createOrderService();

    PaymentService createPaymentService();

    DeliveryService createDeliveryService();
}
