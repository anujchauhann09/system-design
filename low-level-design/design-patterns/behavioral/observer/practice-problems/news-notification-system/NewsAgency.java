import java.util.ArrayList;
import java.util.List;

class NewsAgency implements Subject {

    private String agencyName;
    private String latestCategory;
    private String latestHeadline;
    private List<Observer> observers = new ArrayList<>();

    NewsAgency(String agencyName) {
        this.agencyName = agencyName;
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
            observer.update(latestCategory, latestHeadline);
        }
    }

    public void publishNews(String category, String headline) {
        System.out.println("[" + agencyName + "] Breaking: " + headline);
        this.latestCategory = category;
        this.latestHeadline = headline;
        notifyObservers();
    }
}
