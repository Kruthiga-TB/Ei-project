package exercise1.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private final List<StockObserver> observers = new ArrayList<>();
    private Stock currentStock;

    public void setStock(Stock stock) {
        this.currentStock = stock;
        notifyObservers();
    }

    public void addObserver(StockObserver observer) {
        if (observer == null) {
            throw new IllegalArgumentException("Observer cannot be null");
        }
        observers.add(observer);
    }

    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        if (currentStock == null) return;

        for (StockObserver observer : observers) {
            observer.update(currentStock);
        }
    }

    public int getObserverCount() {
        return observers.size();
    }
}