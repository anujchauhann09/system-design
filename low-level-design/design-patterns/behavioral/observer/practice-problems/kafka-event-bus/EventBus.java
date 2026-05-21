import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class EventBus {

    private Map<String, List<EventListener>> topicListeners = new HashMap<>();

    public void subscribe(String topic, EventListener listener) {
        topicListeners.computeIfAbsent(topic, k -> new ArrayList<>()).add(listener);
        System.out.println(listener.getClass().getSimpleName() + " subscribed to topic: " + topic);
    }

    public void unsubscribe(String topic, EventListener listener) {
        List<EventListener> listeners = topicListeners.get(topic);
        if (listeners != null) {
            listeners.remove(listener);
        }
    }

    public void publish(String topic, String message) {
        System.out.println("\n[EventBus] Publishing to topic '" + topic + "': " + message);
        List<EventListener> listeners = topicListeners.getOrDefault(topic, new ArrayList<>());
        for (EventListener listener : listeners) {
            listener.onEvent(topic, message);
        }
    }
}
