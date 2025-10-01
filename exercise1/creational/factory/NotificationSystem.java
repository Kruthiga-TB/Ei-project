package exercise1.creational.factory;

import java.util.Scanner;

public class NotificationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        NotificationFactory factory = new NotificationFactory();

        System.out.println("=== Notification System ===");

        while (running) {
            showMainMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> sendSingleNotification(scanner, factory);
                case "2" -> sendBulkNotifications(scanner, factory);
                case "3" -> showNotificationTypes();
                case "4" -> {
                    running = false;
                    System.out.println("Goodbye! Notifications system closed.");
                }
                default -> System.out.println("Invalid choice. Please enter 1-4.");
            }
        }

        scanner.close();
    }

    private static void showMainMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Send Single Notification");
        System.out.println("2. Send Bulk Notifications");
        System.out.println("3. Show Available Notification Types");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (1-4): ");
    }

    private static void sendSingleNotification(Scanner scanner, NotificationFactory factory) {
        try {
            System.out.println("\n=== Send Single Notification ===");

            // Get notification type
            String type = getNotificationType(scanner);
            if (type == null) return;

            // Get recipient
            String recipient = getRecipient(scanner, type);
            if (recipient == null) return;

            // Get message
            String message = getMessage(scanner, type);
            if (message == null) return;

            // Create and send notification using factory
            Notification notification = factory.createNotification(type, recipient);
            notification.send(message);

            System.out.println("Notification sent successfully!");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    private static void sendBulkNotifications(Scanner scanner, NotificationFactory factory) {
        try {
            System.out.println("\n=== Send Bulk Notifications ===");

            // Get notification type
            String type = getNotificationType(scanner);
            if (type == null) return;

            // Get number of recipients
            System.out.print("Enter number of recipients: ");
            int count;
            try {
                count = Integer.parseInt(scanner.nextLine().trim());
                if (count <= 0 || count > 10) {
                    System.out.println("Please enter between 1 and 10 recipients");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
                return;
            }

            // Get message
            String message = getMessage(scanner, type);
            if (message == null) return;

            // Send to each recipient
            for (int i = 1; i <= count; i++) {
                System.out.print("Enter recipient " + i + ": ");
                String recipient = scanner.nextLine().trim();

                if (recipient.isEmpty()) {
                    System.out.println("Recipient cannot be empty. Skipping...");
                    continue;
                }

                try {
                    Notification notification = factory.createNotification(type, recipient);
                    notification.send(message);
                    System.out.println("Sent to recipient " + i);
                } catch (IllegalArgumentException e) {
                    System.out.println("Failed for recipient " + i + ": " + e.getMessage());
                }
            }

            System.out.println("Bulk notifications completed!");

        } catch (Exception e) {
            System.out.println("Error in bulk notifications: " + e.getMessage());
        }
    }

    private static void showNotificationTypes() {
        System.out.println("\n=== Available Notification Types ===");
        System.out.println("1. Email - Send to email addresses");
        System.out.println("   Example: user@example.com");
        System.out.println("   Features: No length limit");

        System.out.println("\n2. SMS - Send to phone numbers");
        System.out.println("   Example: +91-9876543210");
        System.out.println("   Features: Max 160 characters");

        System.out.println("\n3. Push - Send to mobile devices");
        System.out.println("   Example: device-12345");
        System.out.println("   Features: Instant delivery");

        System.out.println("\nAll types validate recipient format and message content!");
    }

    private static String getNotificationType(Scanner scanner) {
        System.out.println("\nSelect notification type:");
        System.out.println("1. Email");
        System.out.println("2. SMS");
        System.out.println("3. Push");
        System.out.print("Enter choice (1-3): ");

        String choice = scanner.nextLine().trim();
        switch (choice) {
            case "1": return "email";
            case "2": return "sms";
            case "3": return "push";
            default:
                System.out.println("Invalid type selection");
                return null;
        }
    }

    private static String getRecipient(Scanner scanner, String type) {
        switch (type) {
            case "email":
                System.out.print("Enter email address: ");
                break;
            case "sms":
                System.out.print("Enter phone number: ");
                break;
            case "push":
                System.out.print("Enter device ID: ");
                break;
        }

        String recipient = scanner.nextLine().trim();
        if (recipient.isEmpty()) {
            System.out.println("Recipient cannot be empty");
            return null;
        }
        return recipient;
    }

    private static String getMessage(Scanner scanner, String type) {
        System.out.print("Enter your message: ");
        String message = scanner.nextLine().trim();

        if (message.isEmpty()) {
            System.out.println("Message cannot be empty");
            return null;
        }

        if (type.equals("sms") && message.length() > 160) {
            System.out.println("SMS message too long (" + message.length() + " characters)");
            System.out.println("Maximum allowed: 160 characters");
            return null;
        }

        return message;
    }
}
