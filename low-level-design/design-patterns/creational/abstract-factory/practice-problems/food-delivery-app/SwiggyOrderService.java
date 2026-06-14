public class SwiggyOrderService
        implements OrderService {

    @Override
    public void placeOrder(String item) {
        System.out.println("Swiggy order placed: " + item);
    }
}
