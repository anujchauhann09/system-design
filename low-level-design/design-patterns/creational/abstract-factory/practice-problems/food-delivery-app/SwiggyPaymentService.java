public class SwiggyPaymentService
        implements PaymentService {

    @Override
    public void pay(double amount) {
        System.out.println("Swiggy payment of " + amount + " via Swiggy Money");
    }
}
