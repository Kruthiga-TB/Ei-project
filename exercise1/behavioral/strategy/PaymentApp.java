package exercise1.behavioral.strategy;

import java.util.Scanner;

public class PaymentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Payment System ===");

        while (running) {
            System.out.println("\n1. Credit Card Payment");
            System.out.println("2. PayPal Payment");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> processCreditCardPayment(scanner);
                case "2" -> processPayPalPayment(scanner);
                case "3" -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Please enter 1, 2, or 3");
            }
        }

        scanner.close();
    }

    private static void processCreditCardPayment(Scanner scanner) {
        try {
            System.out.print("Enter card number: ");
            String cardNumber = scanner.nextLine();

            System.out.print("Enter amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            PaymentStrategy strategy = new CreditCardPayment(cardNumber);
            PaymentProcessor processor = new PaymentProcessor(strategy);
            processor.processPayment(amount);

            System.out.println("Payment successful!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid amount");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    private static void processPayPalPayment(Scanner scanner) {
        try {
            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            System.out.print("Enter amount: ");
            double amount = Double.parseDouble(scanner.nextLine());

            PaymentStrategy strategy = new PayPalPayment(email);
            PaymentProcessor processor = new PaymentProcessor(strategy);
            processor.processPayment(amount);

            System.out.println("Payment successful!");

        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid amount");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}