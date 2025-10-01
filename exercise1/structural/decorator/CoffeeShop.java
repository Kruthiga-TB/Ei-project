package exercise1.structural.decorator;

import java.util.Scanner;

public class CoffeeShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Simple Coffee Shop (₹) ===");

        while (running) {
            System.out.println("\n1. Build Drink");
            System.out.println("2. Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> buildDrink(scanner);
                case "2" -> {
                    running = false;
                    System.out.println("Thank you!");
                }
                default -> System.out.println("Please enter 1 or 2");
            }
        }

        scanner.close();
    }

    private static void buildDrink(Scanner scanner) {
        try {
            Drink drink = new Coffee();

            System.out.println("\nStarting with: " + drink.getDescription() + " - ₹" + drink.getCost());

            // Ask about milk
            System.out.print("Add milk? (+₹10) (y/n): ");
            String addMilk = scanner.nextLine();
            if (addMilk.equalsIgnoreCase("y")) {
                drink = new MilkDecorator(drink);
                System.out.println("Added milk: " + drink.getDescription() + " - ₹" + drink.getCost());
            }

            // Ask about sugar
            System.out.print("Add sugar? (+₹5) (y/n): ");
            String addSugar = scanner.nextLine();
            if (addSugar.equalsIgnoreCase("y")) {
                drink = new SugarDecorator(drink);
                System.out.println("Added sugar: " + drink.getDescription() + " - ₹" + drink.getCost());
            }

            // Ask about cream (NEW)
            System.out.print("Add cream? (+₹20) (y/n): ");
            String addCream = scanner.nextLine();
            if (addCream.equalsIgnoreCase("y")) {
                drink = new CreamDecorator(drink);
                System.out.println("Added cream: " + drink.getDescription() + " - ₹" + drink.getCost());
            }

            // Show final drink
            System.out.println("\n=== YOUR DRINK ===");
            System.out.println(drink.getDescription());
            System.out.println("Total: ₹" + drink.getCost());
            System.out.println("==================");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}