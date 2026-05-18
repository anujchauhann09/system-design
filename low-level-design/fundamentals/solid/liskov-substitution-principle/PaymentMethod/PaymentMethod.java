abstract class PaymentMethod {
    abstract boolean processPayment(double amount);
    abstract boolean refund(double amount);
}
