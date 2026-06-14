public class SwiggyDeliveryService
        implements DeliveryService {

    @Override
    public void deliver(String address) {
        System.out.println("Swiggy delivering to " + address + " via Swiggy Genie");
    }
}
