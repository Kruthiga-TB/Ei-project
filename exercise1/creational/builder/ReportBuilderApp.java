package exercise1.creational.builder;

import java.util.Scanner;

public class ReportBuilderApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Report Builder ===");

        while (running) {
            System.out.println("\n1. Build Report");
            System.out.println("2. Show Example");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> buildReport(scanner);
                case "2" -> showExample();
                case "3" -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Please enter 1, 2, or 3");
            }
        }

        scanner.close();
    }

    private static void buildReport(Scanner scanner) {
        try {
            Report.Builder builder = new Report.Builder();

            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            builder.title(title);

            System.out.print("Enter author: ");
            String author = scanner.nextLine();
            builder.author(author);

            System.out.print("Enter content (or press Enter to skip): ");
            String content = scanner.nextLine();
            if (!content.trim().isEmpty()) {
                builder.content(content);
            }

            Report report = builder.build();

            System.out.println("\n--- Report Created ---");
            System.out.println(report);
            System.out.println("----------------------");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void showExample() {
        try {
            Report example = new Report.Builder()
                    .title("Monthly Report")
                    .author("John Smith")
                    .content("This is an example report content")
                    .build();

            System.out.println("\n--- Example Report ---");
            System.out.println(example);
            System.out.println("----------------------");

        } catch (Exception e) {
            System.out.println("Error creating example: " + e.getMessage());
        }
    }
}