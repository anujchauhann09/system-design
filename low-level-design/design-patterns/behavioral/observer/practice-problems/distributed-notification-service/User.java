import java.util.ArrayList;
import java.util.List;

class User {
    String userId;
    private List<NotificationChannel> channels = new ArrayList<>();

    User(String userId) {
        this.userId = userId;
    }

    void addChannel(NotificationChannel channel) {
        channels.add(channel);
    }

    void notify(String message) {
        for (NotificationChannel channel : channels) {
            channel.send(userId, message);
        }
    }
}
