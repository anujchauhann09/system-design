import java.util.ArrayList;
import java.util.List;

class YoutubeChannel implements Subject {

    private String channelName;
    private List<Observer> observers = new ArrayList<>();

    YoutubeChannel(String channelName) {
        this.channelName = channelName;
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
            observer.update(channelName, "New video uploaded!");
        }
    }

    public void uploadVideo(String videoTitle) {
        System.out.println(channelName + " uploaded: " + videoTitle);
        notifyObservers();
    }
}
