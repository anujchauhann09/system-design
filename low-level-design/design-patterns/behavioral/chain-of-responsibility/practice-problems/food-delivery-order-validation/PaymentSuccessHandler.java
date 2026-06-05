class PaymentSuccessHandler extends Handler {

    @Override
    public void handle(Order order) {
        if (!order.isPaymentSuccess()) {
            System.out.println("Order " + order.getId() + " rejected: payment failed");
            return;   // short-circuit the chain
        }
        System.out.println("[OK] payment captured");
        forward(order);
    }
}
