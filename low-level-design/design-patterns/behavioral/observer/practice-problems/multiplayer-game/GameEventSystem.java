import java.util.ArrayList;
import java.util.List;

class GameEventSystem implements Subject {

    private String eventType;
    private String details;
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(eventType, details);
        }
    }

    public void triggerEvent(String eventType, String details) {
        System.out.println("[GameEvent] " + eventType + ": " + details);
        this.eventType = eventType;
        this.details = details;
        notifyObservers();
    }
}
