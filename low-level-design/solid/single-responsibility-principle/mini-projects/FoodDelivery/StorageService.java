import java.util.ArrayList;
import java.util.List;

class StorageService {

    List<Order> orders = new ArrayList<>();

    void save(Order order) {
        orders.add(order);
        System.out.println("Order " + order.orderId + " saved.");
    }
}
