class PaymentGatewayFactory {
    public PaymentGateway createGateway(String type) {

        switch (type.toLowerCase()) {
            case "stripe":
                return new Stripe();
            case "paypal":
                return new PayPal();
            case "razorpay":
                return new Razorpay();
            default:
                throw new IllegalArgumentException("Unknown gateway: " + type);
        }
    }
}
