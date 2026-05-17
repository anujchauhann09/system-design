class EmailService {

    void sendEmail(Order order) {
        System.out.println("Email sent to " + order.customerName + " for order " + order.orderId);
    }
}
