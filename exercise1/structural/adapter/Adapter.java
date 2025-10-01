package exercise1.structural.adapter;

import java.util.Scanner;

public class Adapter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Create adapter once
        LegacyPaymentSystem legacySystem = new LegacyPaymentSystem();
        ModernPayment paymentAdapter = new LegacyPaymentAdapter(legacySystem);

        System.out.println("=== Payment Adapter System ===");

        while (running) {
            showMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1"-> processPayment(scanner, paymentAdapter);
                case "2"-> testDifferentCards(scanner, paymentAdapter);
                case "3"-> {
                    running = false;
                    System.out.println("Thank you for using Payment System!");
                }
                default-> System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }

            if (running) {
                System.out.println("\n" + "=".repeat(40));
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\nPlease choose an option:");
        System.out.println("1. Process Payment");
        System.out.println("2. Test Different Card Formats");
        System.out.println("3. Exit");
        System.out.print("Enter your choice (1-3): ");
    }

    private static void processPayment(Scanner scanner, ModernPayment payment) {
        try {
            System.out.print("Enter card number: ");
            String cardNumber = scanner.nextLine().trim();

            if (cardNumber.isEmpty()) {
                System.out.println("Error: Card number cannot be empty");
                return;
            }

            System.out.print("Enter payment amount: ");
            String amountInput = scanner.nextLine().trim();
            double amount;

            try {
                amount = Double.parseDouble(amountInput);
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number for amount");
                return;
            }

            System.out.println("\nProcessing payment...");
            boolean success = payment.pay(cardNumber, amount);

            if (success) {
                System.out.println("Payment processed successfully!");
            } else {
                System.out.println("Payment failed!");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    private static void testDifferentCards(Scanner scanner, ModernPayment payment) {
        String[] testCards = {
                "4111-1111-1111-1111",
                "5500-0000-0000-0004",
                "3400-0000-0000-009",
                "6011-0000-0000-0004",
                "1234-5678-9012-3456"
        };

        System.out.println("\n=== Testing Different Card Formats ===");
        System.out.println("Testing 5 different card formats with ₹10.00 payment...");

        for (int i = 0; i < testCards.length; i++) {
            try {
                System.out.println("\nTest " + (i + 1) + ": Card " + testCards[i]);
                boolean success = payment.pay(testCards[i], 10.00);
                System.out.println("Result: " + (success ? "SUCCESS" : "FAILED"));

                // Small delay for readability
                Thread.sleep(500);

            } catch (IllegalArgumentException e) {
                System.out.println("Result: ERROR - " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Result: UNEXPECTED ERROR - " + e.getMessage());
            }
        }

        System.out.println("\nAll tests completed!");
    }
}
