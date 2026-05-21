interface Subject {

    void addObserver(Observer observe);
    void removeObserver(Observer observe);
    void notifyObservers();
}