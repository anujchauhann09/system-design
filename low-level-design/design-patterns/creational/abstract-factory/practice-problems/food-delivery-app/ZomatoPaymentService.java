public class ZomatoPaymentService
        implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Zomato payment of " + amount + " via Zomato Pay");
    }
}
