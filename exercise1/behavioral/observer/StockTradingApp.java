package exercise1.behavioral.observer;

import java.util.Scanner;

public class StockTradingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        StockMarket market = new StockMarket();

        System.out.println("=== Stock Trading System ===");

        while (running) {
            System.out.println("\n1. Add Trader");
            System.out.println("2. Update Stock Price");
            System.out.println("3. Show Traders Count");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addTrader(scanner, market);
                case "2" -> updateStockPrice(scanner, market);
                case "3" -> showTradersCount(market);
                case "4" -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Please enter 1, 2, 3, or 4");
            }
        }
        scanner.close();
    }

    private static void addTrader(Scanner scanner, StockMarket market) {
        try {
            System.out.print("Enter trader name: ");
            String name = scanner.nextLine();

            StockTrader trader = new StockTrader(name);
            market.addObserver(trader);

            System.out.println("Trader " + name + " added to market");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    private static void updateStockPrice(Scanner scanner, StockMarket market) {
        try {
            System.out.print("Enter stock symbol: ");
            String symbol = scanner.nextLine();

            System.out.print("Enter new price: ");
            double price = Double.parseDouble(scanner.nextLine());

            Stock stock = new Stock(symbol, price);
            market.setStock(stock);

            System.out.println("Stock price updated: " + stock);

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid price");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    private static void showTradersCount(StockMarket market) {
        System.out.println("Active traders: " + market.getObserverCount());
    }
}
