import java.util.ArrayList;
import java.util.List;

class Item {
    String name;
    double price;
    int quantity;
}

class ShoppingCart {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(String name) {
        items.removeIf(item -> item.name.equals(name));
    }

    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.price * item.quantity;
        }
        return total;
    }
}
