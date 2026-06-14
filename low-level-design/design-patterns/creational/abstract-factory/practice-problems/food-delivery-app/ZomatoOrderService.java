public class ZomatoOrderService
        implements OrderService {

    @Override
    public void placeOrder(String item) {
        System.out.println("Zomato order placed: " + item);
    }
}
