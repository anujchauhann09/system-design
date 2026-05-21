import java.util.ArrayList;
import java.util.List;

class NotificationService {

    private List<User> users = new ArrayList<>();

    void register(User user) {
        users.add(user);
    }

    void unregister(User user) {
        users.remove(user);
    }

    void broadcast(String message) {
        System.out.println("\n[NotificationService] Broadcasting: " + message);
        for (User user : users) {
            user.notify(message);
        }
    }
}
