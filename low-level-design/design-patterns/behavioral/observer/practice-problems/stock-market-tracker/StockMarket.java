import java.util.ArrayList;
import java.util.List;

class StockMarket implements Subject {

    private String stockSymbol;
    private double price;
    private List<Observer> observers = new ArrayList<>();

    StockMarket(String stockSymbol) {
        this.stockSymbol = stockSymbol;
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
            observer.update(stockSymbol, price);
        }
    }

    public void updatePrice(double price) {
        System.out.println(stockSymbol + " price updated to: " + price);
        this.price = price;
        notifyObservers();
    }
}
