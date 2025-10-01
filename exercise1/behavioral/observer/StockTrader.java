package exercise1.behavioral.observer;

public class StockTrader implements StockObserver {
    private final String name;

    public StockTrader(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Trader name cannot be empty");
        }
        this.name = name;
    }

    @Override
    public void update(Stock stock) {
        System.out.println("Trader " + name + " notified - " + stock);
    }
}
