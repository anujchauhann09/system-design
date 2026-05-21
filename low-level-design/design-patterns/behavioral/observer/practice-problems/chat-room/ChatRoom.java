import java.util.ArrayList;
import java.util.List;

class ChatRoom implements Subject {

    private String roomName;
    private String lastSender;
    private String lastMessage;
    private List<Observer> observers = new ArrayList<>();

    ChatRoom(String roomName) {
        this.roomName = roomName;
    }

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
            observer.update(lastSender, lastMessage);
        }
    }

    public void sendMessage(String sender, String message) {
        System.out.println("[" + roomName + "] " + sender + ": " + message);
        this.lastSender = sender;
        this.lastMessage = message;
        notifyObservers();
    }
}
