public class ZomatoDeliveryService
        implements DeliveryService {

    @Override
    public void deliver(String address) {
        System.out.println("Zomato delivering to " + address + " via Zomato Fleet");
    }
}
