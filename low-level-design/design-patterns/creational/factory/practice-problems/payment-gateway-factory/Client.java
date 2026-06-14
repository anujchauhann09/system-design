class Client {
    public static void main(String[] args) {
        PaymentGatewayFactory factory = new PaymentGatewayFactory();

        factory.createGateway("stripe").pay(100.0);     
        factory.createGateway("paypal").pay(250.0);    
        factory.createGateway("razorpay").pay(500.0);   
    }
}
